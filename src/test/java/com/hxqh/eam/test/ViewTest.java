package com.hxqh.eam.test;

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.dto.EnterpriseTopDto;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.eam.service.EnterpriseService;
import com.hxqh.eam.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lh on 2017/5/5.
 */

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewTest {

    @Autowired
    private SystemService systemService;
    @Autowired
    private EnterpriseService enterpriseService;
    
    @Test
    public void testCreateSQLQuery() {
//        EnterpriseTopDto dbs = enterpriseService.getTopData(1, "DBS");

    }


    @Test
    public void testGetViewData() {
        List<Menu> listData = systemService.getMenuListData();
        Assert.assertTrue(listData.size()>0);
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto("admin","123456");
        List<SfOrganizationAccount> loginUserList = systemService.getLoginUserList(loginDto);
        SfOrganizationAccount account = loginUserList.get(0);
        Assert.assertTrue(account.getPassword().equals(Account.encrypt(loginDto.getPassword())));
    }

    @Test
    public void testLoginShiro() {

        // 1.获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        // 2.获取SecurityManager实例，并绑定到SecurityUtils
        SecurityManager sm = factory.getInstance();
        SecurityUtils.setSecurityManager(sm);

        // 3.得到Subject
        Subject subject = SecurityUtils.getSubject();
        // 4.创建用户登录凭证
        UsernamePasswordToken token = new UsernamePasswordToken("admin", Account.encrypt("123456"));
        // 5.登录，如果登录失败会抛出不同的异常，根据异常输出失败原因
        try {
            subject.login(token);
            // 6.判断是否成功登录
            Assert.assertEquals(true, subject.isAuthenticated());
            //System.out.println("登录成功！！");
            // 7.注销用户
            subject.logout();
        } catch (IncorrectCredentialsException e) {
            System.out.println("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");
        } catch (ExcessiveAttemptsException e) {
            System.out.println("登录失败次数过多");
        } catch (LockedAccountException e) {
            System.out.println("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
        } catch (DisabledAccountException e) {
            System.out.println("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
        } catch (ExpiredCredentialsException e) {
            System.out.println("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
        } catch (UnknownAccountException e) {
            System.out.println("帐号不存在. There is no user with username of " + token.getPrincipal());
        }
    }



}




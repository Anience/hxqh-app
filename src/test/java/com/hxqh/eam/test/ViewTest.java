package com.hxqh.eam.test;

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.dao.SfOrganizationAccountDao;
import com.hxqh.eam.dao.VAno81Dao;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.service.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lh on 2017/5/5.
 */

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ViewTest {

    @Resource
    private VAno81Dao vAno81Dao;

    @Resource
    private SfOrganizationAccountDao organizationAccountDao;

    @Autowired
    private SystemService systemService;

    @Test
    public void testGetViewData() {
        List<VAno81> all = vAno81Dao.findAll();
        Assert.assertTrue(all.size() > 0);
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto("admin","123456");
        List<SfOrganizationAccount> loginUserList = systemService.getLoginUserList(loginDto);
        SfOrganizationAccount account = loginUserList.get(0);
        Assert.assertTrue(account.getPassword().equals(Account.encrypt(loginDto.getPassword())));
    }


}

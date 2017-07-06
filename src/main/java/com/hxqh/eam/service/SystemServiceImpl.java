package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.AccountDto;
import com.hxqh.eam.dao.MenuDao;
import com.hxqh.eam.dao.SfOrganizationAccountDao;
import com.hxqh.eam.dao.SfOrganizationDepartmentDao;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.SfOrganizationDepartment;
import com.hxqh.eam.model.dto.RoleDto;
import com.hxqh.eam.model.dto.action.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SfOrganizationAccountDao organizationAccountDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SfOrganizationDepartmentDao sfOrganizationDepartmentDao;

    @Override
    public List<SfOrganizationAccount> getLoginUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", loginDto.getName());
        String where = "name=:name ";
        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public List<Menu> getMenuListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        //        params.put("name", "");
        //        String where = "name=:name ";
        //        List<Menu> menuList = menuDao.findAll(where, params, null);
        List<Menu> menuList = menuDao.findAll();
        return menuList;
    }

    @Override
    public void editMenu(Menu menu) throws Exception {
        menuDao.update(menu);
    }

    @Override
    public void addMenu(Menu menu) throws Exception {
        menuDao.save(menu);
    }

    @Override
    public void delMenu(String menuid) throws Exception {
        menuDao.delete(menuid);
    }

    @Override
    public AccountDto getUserListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));

        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll();
        long allUser = organizationAccountDao.getCount();
        long normal = organizationAccountDao.getCount();
        long onlineUser = organizationAccountDao.getCount("login=:login",params);

        AccountDto accountDto = new AccountDto(accountList, allUser, normal, onlineUser);
        return accountDto;
    }

    @Override
    public RoleDto getRoleListData() {
        return null;
    }

    @Override
    public void editUser(SfOrganizationAccount account) {
        organizationAccountDao.update(account);
    }

    @Override
    public void addUser(SfOrganizationAccount account) {
        organizationAccountDao.save(account);
    }

    @Override
    public void delUser(String id) {
        organizationAccountDao.delete(id);
    }


    @Override
    public List<SfOrganizationAccount> findOnlineUserList() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));
        String where = "login=:login ";
        List<SfOrganizationAccount> organizationAccountList = organizationAccountDao.findAll(where, params, null);
        return organizationAccountList;
    }

    @Override
    public List<SfOrganizationDepartment> getDepartmentList() {
        return sfOrganizationDepartmentDao.findAll();
    }

}

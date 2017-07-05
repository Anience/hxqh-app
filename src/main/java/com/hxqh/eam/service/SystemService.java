package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.AccountDto;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.SfOrganizationDepartment;
import com.hxqh.eam.model.dto.action.LoginDto;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface SystemService {

    List<SfOrganizationAccount> getLoginUserList(LoginDto loginDto);

    List<Menu> getMenuListData();

    void editMenu(Menu menu) throws Exception;

    void addMenu(Menu menu) throws Exception;

    void delMenu(String menuid) throws Exception;

    void editUser(SfOrganizationAccount account);

    void addUser(SfOrganizationAccount account);

    void delUser(String menuid);

    List<SfOrganizationAccount> findOnlineUserList();

    List<SfOrganizationDepartment> getDepartmentList();

    AccountDto getUserListData();
}

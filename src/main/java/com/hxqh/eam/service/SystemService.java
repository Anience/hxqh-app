package com.hxqh.eam.service;

import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;

import java.math.BigDecimal;
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

    void editUser(UserObj account);

    int addUser(UserObj account, Long roleid);

    void delUser(Long menuid);


    List<SfOrganizationAccount> findOnlineUserList();

    List<SfOrganizationDepartment> getDepartmentList();

    UserDto getUserListData();

    List<TbRole> getRoleListData();

    List<TbIoccustomeruser> customeruserListData(String name, String div);

    void updateRank(Long ioccustomeruserid, String custid, String name);

    TbIocCustTop7 getrankDetail(String ioccustomerusertop7id);

    void callProcedure();

    TestDto testData();

    void userRole(String id, BigDecimal roleid);

    UserObj findUserbyId(Long id);

    ModelDto getModelListData();

    void editrole(TbRole account);


    int addrole(TbRole account);


    void delrole(Long id);


    void editmodel(TbModel account);

    void addmodel(TbModel account);

    void delmodel(String id);

    void roleModel(String models, Long roleid);

    ModelRoleDto getModelRoleData(Long roleid);

    List<TbRole> findRoleList();

    List<UserObj> getUserList(LoginDto loginDto);

    int forgetPassword(String loginname, String email);

    int resetPassword(Long loginname, String password);

    int sendEmail(String loginname, String email);

    ModelIndexDto getModelIndex(String loginname);

    int modifyPassword(String password, String name);

    List<TbIocCustTop7> custtop7ListData(String custnum, String custname, String custtype, Integer rank);
}

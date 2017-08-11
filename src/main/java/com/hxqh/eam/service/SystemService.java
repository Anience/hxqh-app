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

    void editUser(SfOrganizationAccount account);

    void addUser(SfOrganizationAccount account);

    void delUser(String menuid);

    List<SfOrganizationAccount> findOnlineUserList();

    List<SfOrganizationDepartment> getDepartmentList();

    UserDto getUserListData();

    RoleDto getRoleListData();

    List<TbIocCustTop7> custtop7ListData();

    List<TbIoccustomeruser> customeruserListData(String name,String div);

    void updateRank(Long ioccustomeruserid,String custid,String name);

    TbIocCustTop7 getrankDetail(String ioccustomerusertop7id);

    void callProcedure();

    TestDto testData();

    void userRole(String id, BigDecimal roleid);

    SfOrganizationAccount findUserbyId(String id);

    ModelDto getModelListData();

    void editrole(TbRole account);

    void addrole(TbRole account);

    void delrole(String id);

    void editmodel(TbModel account);

    void addmodel(TbModel account);

    void delmodel(String id);

    void roleModel(String models, BigDecimal roleid);

    ModelRoleDto getModelRoleData();
}

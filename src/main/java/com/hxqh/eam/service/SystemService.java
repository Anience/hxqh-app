package com.hxqh.eam.service;

import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.webService.model.RoleSource;

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


    /**
     * 批量修改
     *
     * @param objList
     * @return
     */
    String editUser(List<UserObj> objList);

    String addUser(List<UserObj> objList);

    int addUser(UserObj account, Long roleid);

    void delUser(Long menuid);

    /**
     * 接口删除用户
     *
     * @param sourceIds
     */
    String delUser(List<UserObj> sourceIds);

    List<SfOrganizationAccount> findOnlineUserList();

    List<SfOrganizationDepartment> getDepartmentList();

    UserDto getUserListData();

    List<TbRole> getRoleListData();

    List<TbIocCustTop7> custtop7ListData();

    List<TbIoccustomeruser> customeruserListData(String name, String div);

    void updateRank(Long ioccustomeruserid, String custid, String name);

    TbIocCustTop7 getrankDetail(String ioccustomerusertop7id);

    void callProcedure();

    TestDto testData();

    void userRole(String id, BigDecimal roleid);

    UserObj findUserbyId(Long id);

    ModelDto getModelListData();

    void editrole(TbRole account);

    /**
     * 批量编辑角色 add Ocean_hy
     *
     * @param tbRoleList
     * @return
     */
    String editrole(List<TbRole> tbRoleList);

    int addrole(TbRole account);

    /**
     * 批量新增角色 Add Ocean
     *
     * @param tbRoleList
     * @return
     */
    String addrole(List<TbRole> tbRoleList);

    String addRoleSource(List<RoleSource> tbRoleList);
    String editRoleSource(List<RoleSource> tbRoleList);
    String delRoleSource(List<RoleSource> tbRoleList);




    void delrole(Long id);

    /**
     * 批量删除角色
     * add Ocean
     * @param tbRoleList
     * @return
     */
    String delrole(List<TbRole> tbRoleList);

    void editmodel(TbModel account);

    void addmodel(TbModel account);

    void delmodel(String id);

    void roleModel(String models, Long roleid);

    ModelRoleDto getModelRoleData(Long roleid);

    List<TbRole> findRoleList();

    List<UserObj> getUserList(LoginDto loginDto);

    int forgetPassword(String loginname, String email);

    int resetPassword(Long loginname);

    int sendEmail(String loginname, String email);

    ModelIndexDto getModelIndex(String loginname);
}

package com.hxqh.webService.service.imp;

import com.google.gson.JsonParser;
import com.hxqh.eam.common.util.JsonUtil;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.TbRole;
import com.hxqh.eam.model.UserObj;
import com.hxqh.eam.model.dto.UserDto;
import com.hxqh.eam.service.SystemService;
import com.hxqh.webService.model.RetrunVal;
import com.hxqh.webService.model.RoleSource;
import com.hxqh.webService.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  CommonServiceImp.java                             §
 * §┇File Path: com.hxqh.webService.service.imp.CommonServiceImp           §
 * §Descrption:     实现接口                                     §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
@Repository
@Transactional
@WebService
public class CommonServiceImp implements CommonService {
    @Autowired
    private SystemService systemService;

    @Override
    public String getUserList() {
        UserDto userDto = systemService.getUserListData();
        String jsonVal = JsonUtil.object2Json(userDto);
        return jsonVal;
    }

    /**
     * 获取角色列表
     *
     * @return
     */
    @Override
    public String getRoleList() {
        List<TbRole> roleDto = systemService.getRoleListData();
        for (TbRole e : roleDto) {
            e.setTbRolemodels(null);
            e.setTbUserroles(null);
        }
        String jsonVal = JsonUtil.list2Json(roleDto);
        return jsonVal;
    }

    /**
     * 获取资源列表
     *
     * @return
     */
    @Override
    public String getResouleList() {
        List<Menu> menuList = systemService.getMenuListData();
        String jsonVal = JsonUtil.list2Json(menuList);
        return jsonVal;
    }

    /**
     * 操作用户（修改）
     *
     * @param inPutVal
     * @param optionType 1:新增 2 修改 3 删除
     * @return
     */
    @Override
    public String OptionUser(String inPutVal, int optionType) {
        RetrunVal retrunVal = new RetrunVal();
        boolean valid = ValidInputVal(inPutVal);
        if (valid) {
            List<UserObj> userObjList = JsonUtil.json2List(inPutVal, UserObj.class);
            if (userObjList.size() > 0) {
                String option_msg = "";
                switch (optionType) {
                    case 1:
                        option_msg = systemService.addUser(userObjList);
                        break;
                    case 2:
                        option_msg = systemService.editUser(userObjList);
                        break;
                    case 3:
                        option_msg = systemService.delUser(userObjList);
                        break;
                    default:
                        option_msg = "操作标识未知！";
                }
                retrunVal.setMsg(option_msg);
                retrunVal.setCode("1");
            } else {
                retrunVal.setMsg("解析出错，请联系管理员!");
                retrunVal.setCode("-1");
            }
        } else {
            retrunVal.setMsg("参数不合格，请重新输入!");
            retrunVal.setCode("-1");
        }
        return getReturnJsonVal(retrunVal);
    }

    /**
     * 角色操作
     *
     * @param inPutVal
     * @param optionType
     * @return
     * 1:新增 2 修改 3 删除
     */
    @Override
    public String OptionRole(String inPutVal, int optionType) {
        RetrunVal retrunVal = new RetrunVal();
        boolean valid = ValidInputVal(inPutVal);
        if (valid) {
            List<TbRole> tbRoles = JsonUtil.json2List(inPutVal, TbRole.class);
            if (tbRoles.size() > 0) {
                String option_msg = "";
                switch (optionType) {
                    case 1:
                        option_msg = systemService.addrole(tbRoles);
                        break;
                    case 2:
                         option_msg = systemService.editrole(tbRoles);
                        break;
                    case 3:
                        option_msg = systemService.delrole(tbRoles);
                        break;
                    default:
                        option_msg = "操作标识未知！";
                }
                retrunVal.setMsg(option_msg);
                retrunVal.setCode("1");
            } else {
                retrunVal.setMsg("解析出错，请联系管理员!");
                retrunVal.setCode("-1");
            }
        } else {
            retrunVal.setMsg("参数不合格，请重新输入!");
            retrunVal.setCode("-1");
        }
        return getReturnJsonVal(retrunVal);
    }

    /**
     * 操作角色拥有的资源以及关联的用户
     *
     * @param inPutVal
     * @param optionType
     * @return
     */
    @Override
    public String OptionRoleSource(String inPutVal, int optionType) {
        RetrunVal retrunVal = new RetrunVal();
        boolean valid = ValidInputVal(inPutVal);
        if (valid) {
            List<RoleSource> roleSources = JsonUtil.json2List(inPutVal, RoleSource.class);
            if (roleSources.size() > 0) {
                String option_msg = "";
                switch (optionType) {
                    case 1:
                        option_msg = systemService.addRoleSource(roleSources);
                        break;
                    case 2:
                        option_msg = systemService.editRoleSource(roleSources);
                        break;
                    case 3:
                        option_msg = systemService.delRoleSource(roleSources);
                        break;
                    default:
                        option_msg = "操作标识未知！";
                }
                retrunVal.setMsg(option_msg);
                retrunVal.setCode("1");
            } else {
                retrunVal.setMsg("解析出错，请联系管理员!");
                retrunVal.setCode("-1");
            }
        } else {
            retrunVal.setMsg("参数不合格，请重新输入!");
            retrunVal.setCode("-1");
        }
        return getReturnJsonVal(retrunVal);
    }


    /**
     * 获得返回值为Json
     *
     * @param retrunVal
     * @return
     */
    public static String getReturnJsonVal(RetrunVal retrunVal) {
        return JsonUtil.object2Json(retrunVal);
    }

    /**
     * 校验输入的数据是否正确
     *
     * @return
     */
    public static boolean ValidInputVal(String inPutVal) {
        boolean validStatus = false;
        if (StringUtils.isBlank("") && StringUtils.isEmpty("")
                && StringUtils.isEmpty(null) && StringUtils.isEmpty(null)) {
            inPutVal = inPutVal.replaceAll(" ", "");
            Boolean json = new JsonParser().parse(inPutVal).isJsonArray();
            validStatus = json;
        }
        return validStatus;
    }
}

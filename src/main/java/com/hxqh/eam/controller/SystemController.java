package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.common.IConstants;
import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.base.Message;
import com.hxqh.eam.model.base.SessionInfo;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.eam.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
@SessionAttributes(value = "sessionInfo")
public class SystemController {

    @Autowired
    private SystemService systemService;

    /****************************login logout************************/
    /**
     * first 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {
        return "login";
    }


    /**
     * index 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * logoutnonesession 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/logoutnonesession", method = RequestMethod.GET)
    public String logoutnonesession() {
        return "login";
    }


    /**
     * 登录Function
     *
     * @param loginDto 登录dto
     * @param map      前台返回信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(LoginDto loginDto, Map<String, Object> map) {
//        List<SfOrganizationAccount> loginUserList = systemService.getLoginUserList(loginDto);
        List<UserObj> loginUserList = systemService.getUserList(loginDto);
        return webLogin(loginUserList, loginDto, map);
    }

    private Message webLogin(List<UserObj> loginUserList, LoginDto loginDto, Map<String, Object> map) {
        Message message = new Message(0, "");
        Message success = new Message(1, "LoginSuccess");

        Map<String, Object> result = new HashMap<>();
        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = Account.encrypt(loginDto.getPassword());
                if (loginUserList.get(0).getLoginpassword().toUpperCase().equals(password)) {
                    //加入Session中
//                    SfOrganizationAccount login = loginUserList.get(0);
                    UserObj login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo();

                    sessionInfo.setName(login.getLoginname());
                    map.put("sessionInfo", sessionInfo);
                    return success;
                } else {
                    message.setMessage("Password authentication error!");
                    return message;
                }
            } catch (Exception e) {
                message.setMessage("System exception, please contact the administrator！");
                e.printStackTrace();
                return message;
            }
        } else {
            //用户名不存在
            message.setMessage("The account does not exist!");
            return message;
        }
    }

    /**
     * 注销，销毁Session 重定向至login
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("sessionInfo");
        session.invalidate();
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        //SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出!");
        return "redirect:/login.jsp";
    }
    /****************************login logout************************/


    /****************************Security Menu Configure*************/
    /**
     * menu List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/menuList", method = RequestMethod.GET)
    public String menuList() {
        return "security/menuList";
    }


    /**
     * menu 新增与修改公用页面
     *
     * @param operate 前台传入操作标识符
     * @return
     */
    @RequestMapping(value = "/menuDetail", method = RequestMethod.GET)
    public ModelAndView menuDetail(@RequestParam("operate") String operate) {
        Map<String, Object> result = new HashMap<>();
        result.put("operate", operate);
        return new ModelAndView("security/menuDetail", result);
    }

    /**
     * menuListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menuListData", method = RequestMethod.GET)
    public List<Menu> menuListData() {
        List<Menu> menuList = systemService.getMenuListData();
        return menuList;
    }


    /**
     * editMenu 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editMenu", method = RequestMethod.GET)
    public Message editMenu(Menu menu) {
        Message message = null;
        try {
            systemService.editMenu(menu);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITSUCCESS);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addMenu 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addMenu", method = RequestMethod.GET)
    public Message addMenu(Menu menu) {
        Message message = null;
        try {
            systemService.addMenu(menu);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * delMenu 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delMenu", method = RequestMethod.GET)
    public Message delMenu(@RequestParam("menuid") String menuid) {
        Message message = null;
        try {
            systemService.delMenu(menuid);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }
    /****************************Security Menu Configure*************/


    /****************************** Rank ***************************/
    /**
     * Rank List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/rankList", method = RequestMethod.GET)
    public String rankList() {
        return "rank/rankList";
    }

    /**
     * custtop7ListData 数据接口
     * ok
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/custtop7ListData", method = RequestMethod.GET)
    public List<TbIocCustTop7> custtop7ListData() {
        return systemService.custtop7ListData();
    }

    /**
     * RankDetail页面接口
     *
     * @return
     */
    @RequestMapping(value = "/rankDetail", method = RequestMethod.GET)
    public ModelAndView rankDetail(@RequestParam("ioccustomerusertop7id") String ioccustomerusertop7id) {
        Map<String, Object> result = new HashMap<>();
        result.put("custid", ioccustomerusertop7id);
        return new ModelAndView("rank/rankDetail", result);
    }


    /**
     * Detail页面接口
     * OK
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getrankDetail", method = RequestMethod.GET)
    public TbIocCustTop7 getrankDetail(@RequestParam("ioccustomerusertop7id") String ioccustomerusertop7id) {
        return systemService.getrankDetail(ioccustomerusertop7id);
    }

    /**
     * customeruserListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customeruserListData", method = RequestMethod.GET)
    public List<TbIoccustomeruser> customeruserListData(@RequestParam("name") String name, @RequestParam("div") String div) {
        return systemService.customeruserListData(name, div);
    }


    /**
     * 更新排名的业务接口
     *
     * @param ioccustomeruserid 需要更新的ioccustomeruserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateRank", method = RequestMethod.GET)
    public Message updateRank(
            @RequestParam("ioccustomeruserid") Long ioccustomeruserid,
            @RequestParam("ioccustomerusertop7id") String ioccustomerusertop7id,
            @RequestParam("name") String name) {
        Message message = null;
        try {
            systemService.updateRank(ioccustomeruserid, ioccustomerusertop7id, name);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /****************************** Rank ***************************/


    /****************************User Configure**********************/

    /**
     * User management List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList() {
        return "authority/user";
    }


    /**
     * userListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userListData", method = RequestMethod.GET)
    public UserDto userListData() {
        UserDto userDto = systemService.getUserListData();
        return userDto;
    }

    /**
     * 获取User信息数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userDetailData", method = RequestMethod.GET)
    public UserDetailDataDto userDetailData(@RequestParam("id") Long id) {
        UserObj account = systemService.findUserbyId(id);
        List<TbRole> roleList = systemService.findRoleList();
        for(TbRole role:roleList)
        {
            role.setTbUserroles(null);
        }
        account.setTbUserroles(null);
        return new UserDetailDataDto(account, roleList);
    }


    /**
     * editUser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public Message editUser(UserObj account) {
        Message message = null;
        try {
            systemService.editUser(account);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITSUCCESS);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addUser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public Message addUser(UserObj account, @RequestParam("roleid") Long roleid) {
        Message message = null;
        try {
            systemService.addUser(account, roleid);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * delUser 业务接口
     *
     * @param id 前台传入需要删除id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public Message delUser(@RequestParam("id") Long id) {
        Message message = null;
        try {
            systemService.delUser(id);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /****************************User Configure**********************/


    /****************************Role Configure**********************/
    /**
     * Role management List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/roleList", method = RequestMethod.GET)
    public String roleList() {
        return "authority/role";
    }

    /**
     * roleListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleListData", method = RequestMethod.GET)
    public List<TbRole> roleListData() {
        List<TbRole> roleDto = systemService.getRoleListData();
        for(TbRole e :roleDto)
        {
            e.setTbUserroles(null);
        }
        return roleDto;
    }


    /**
     * role 新增与修改公用页面
     *
     * @param operate 前台传入操作标识符
     * @param id      查询ID
     * @return
     */
    @RequestMapping(value = "/roleDetail", method = RequestMethod.GET)
    public ModelAndView roleDetail(@RequestParam("id") String id, @RequestParam("operate") String operate) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("operate", operate);
        return new ModelAndView("role/roleDetail", result);
    }


    /**
     * editrole 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editrole", method = RequestMethod.GET)
    public Message editrole(TbRole account) {
        Message message = null;
        try {
            systemService.editrole(account);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITSUCCESS);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addrole 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addrole", method = RequestMethod.GET)
    public Message addrole(TbRole account) {
        Message message = null;
        try {
            systemService.addrole(account);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * delrole 业务接口
     *
     * @param id 前台传入需要删除id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delrole", method = RequestMethod.GET)
    public Message delrole(@RequestParam("id") String id) {
        Message message = null;
        try {
            systemService.delrole(id);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * 设置User绑定Role，仅允许一个User一个Role
     */
    @ResponseBody
    @RequestMapping(value = "/userRole", method = RequestMethod.GET)
    public Message userRole(@RequestParam("id") String id, @RequestParam("roleid") BigDecimal roleid) {
        Message message = null;
        try {
            systemService.userRole(id, roleid);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /****************************Role Configure**********************/


    /***************************Model Configure**********************/

    /**
     * Model List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/modelList", method = RequestMethod.GET)
    public String modelList() {
        return "authority/module";
    }

    /**
     * ModelListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modelListData", method = RequestMethod.GET)
    public ModelDto modelListData() {
        ModelDto ModelDto = systemService.getModelListData();
        return ModelDto;
    }

    /**
     * model 新增与修改公用页面
     *
     * @param operate 前台传入操作标识符
     * @param id      查询ID
     * @return
     */
    @RequestMapping(value = "/modelDetail", method = RequestMethod.GET)
    public ModelAndView modelDetail(@RequestParam("id") String id, @RequestParam("operate") String operate) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("operate", operate);
        return new ModelAndView("model/modelDetail", result);
    }


    /**
     * editmodel 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editmodel", method = RequestMethod.GET)
    public Message editmodel(TbModel account) {
        Message message = null;
        try {
            systemService.editmodel(account);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITSUCCESS);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addmodel 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addmodel", method = RequestMethod.GET)
    public Message addmodel(TbModel account) {
        Message message = null;
        try {
            systemService.addmodel(account);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * delmodel 业务接口
     *
     * @param id 前台传入需要删除id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delmodel", method = RequestMethod.GET)
    public Message delmodel(@RequestParam("id") String id) {
        Message message = null;
        try {
            systemService.delmodel(id);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * 一个Role可以设置多个Model
     */
    @ResponseBody
    @RequestMapping(value = "/roleModel", method = RequestMethod.GET)
    public Message roleModel(@RequestParam("roleid") Long roleid, @RequestParam("models") String models) {
        Message message = null;
        try {
            systemService.roleModel(models, roleid);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * 根据role确定已经授权和未授权的模块
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modelRoleData", method = RequestMethod.GET)
    public ModelRoleDto modelRoleData(@RequestParam("roleid") Long roleid) {
        ModelRoleDto data = systemService.getModelRoleData(roleid);
        return data;
    }


    /***************************Model Configure**********************/


}

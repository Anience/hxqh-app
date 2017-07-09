package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.common.IConstants;
import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.SfOrganizationDepartment;
import com.hxqh.eam.model.base.Message;
import com.hxqh.eam.model.base.SessionInfo;
import com.hxqh.eam.model.dto.AccountDto;
import com.hxqh.eam.model.dto.RoleDto;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.eam.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
@SessionAttributes(value = "sessionInfo")
public class SystemController {

    @Autowired
    private SystemService systemService;

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
     * 登录Function
     *
     * @param loginDto 登录dto
     * @param map      前台返回信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(LoginDto loginDto, Map<String, Object> map) {
        List<SfOrganizationAccount> loginUserList = systemService.getLoginUserList(loginDto);
        return webLogin(loginUserList, loginDto, map);
    }

    private Message webLogin(List<SfOrganizationAccount> loginUserList, LoginDto loginDto, Map<String, Object> map) {
        Message message = new Message(0, "");
        Message success = new Message(1, "LoginSuccess");

        Map<String, Object> result = new HashMap<>();
        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password = Account.encrypt(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    SfOrganizationAccount login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo();

                    sessionInfo.setName(login.getName());
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


    /****************************Security Menu Configure**********************/

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

    /****************************User Configure**********************/

    /**
     * User management List页面接口
     *
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList() {
        return "user/userList";
    }


    /**
     * User management OnlineList页面接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/onlineUserList", method = RequestMethod.GET)
    public List<SfOrganizationAccount> onlineUserList() {
        List<SfOrganizationAccount> onlineUserList = systemService.findOnlineUserList();
        return onlineUserList;
    }

    /**
     * User 新增与修改公用页面
     *
     * @param operate 前台传入操作标识符
     * @return
     */
    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public ModelAndView userDetail(@RequestParam("operate") String operate) {
        Map<String, Object> result = new HashMap<>();
        if (operate.equals(IConstants.EDIT) || operate.equals(IConstants.ADD)) {
            List<SfOrganizationDepartment> departmentList = systemService.getDepartmentList();
            result.put("departmentList", departmentList);
        }
        result.put("operate", operate);
        return new ModelAndView("user/userDetail", result);
    }

    /**
     * userListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userListData", method = RequestMethod.GET)
    public AccountDto userListData() {
        AccountDto AccountDto = systemService.getUserListData();
        return AccountDto;
    }

    /**
     * editUser 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public Message editUser(SfOrganizationAccount account) {
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
    public Message addUser(SfOrganizationAccount account) {
        Message message = null;
        try {
            systemService.addUser(account);
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
    public Message delUser(@RequestParam("id") String id) {
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
        return "role/roleList";
    }

    /**
     * roleListData 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/roleListData", method = RequestMethod.GET)
    public RoleDto roleListData() {
        RoleDto roleDto = systemService.getRoleListData();
        return roleDto;
    }



    /****************************Role Configure**********************/


}

package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.base.SessionInfo;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.eam.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(LoginDto loginDto,Map<String, Object> map) {
        List<SfOrganizationAccount> loginUserList = systemService.getLoginUserList(loginDto);
         return webLogin(loginUserList, loginDto, map);
    }

    private String webLogin(List<SfOrganizationAccount> loginUserList, LoginDto loginDto, Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>();
        if (loginUserList.size() > 0) {
            String password = null;
            try {
                password= Account.encrypt(loginDto.getPassword());
                if (loginUserList.get(0).getPassword().toUpperCase().equals(password)) {
                    //加入Session中
                    SfOrganizationAccount login = loginUserList.get(0);
                    SessionInfo sessionInfo = new SessionInfo();
                    sessionInfo.setName(login.getName());
                    map.put("userInfo", sessionInfo);
                    return "system/index";
                } else {
                    result.put("message", "Password authentication error!");
                    return "system/login";
                }
            } catch (Exception e) {
                result.put("message", "System exception, please contact the administrator！");
                e.printStackTrace();
                return "system/login";
            }
        } else {
            //用户名不存在
            result.put("message", "The account does not exist!");
            return "system/login";
        }
    }



}

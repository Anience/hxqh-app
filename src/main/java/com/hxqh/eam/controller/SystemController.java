package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system")
public class SystemController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String getAuthorDetail() {
        return "success";
    }
}

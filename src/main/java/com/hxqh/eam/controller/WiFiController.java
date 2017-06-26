package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wifi")
public class WiFiController {

    @RequestMapping(value = "/wifi", method = RequestMethod.GET)
    public String wifi() {
        return "wifi/wifi";
    }

    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String number() {
        return "wifi/number";
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String ticket() {
        return "wifi/ticket";
    }

    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String daily() {
        return "wifi/daily";
    }

    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public String distribution() {
        return "wifi/distribution";
    }

    @RequestMapping(value = "/mttr", method = RequestMethod.GET)
    public String mttr() {
        return "wifi/mttr";
    }

    @RequestMapping(value = "/monitoring", method = RequestMethod.GET)
    public String monitoring() {
        return "wifi/monitoring";
    }


}

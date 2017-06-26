package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mobile")
public class MobileController {

    @RequestMapping(value = "/mobile87", method = RequestMethod.GET)
    public String mobile87() {
        return "mobile/mobile87";
    }

    @RequestMapping(value = "/mobile86", method = RequestMethod.GET)
    public String mobile86() {
        return "mobile/mobile86";
    }

    @RequestMapping(value = "/mobile88", method = RequestMethod.GET)
    public String mobile88() {
        return "mobile/mobile88";
    }

    @RequestMapping(value = "/mobile89", method = RequestMethod.GET)
    public String mobile89() {
        return "mobile/mobile89";
    }

    @RequestMapping(value = "/mobile91", method = RequestMethod.GET)
    public String mobile91() {
        return "mobile/mobile91";
    }

    @RequestMapping(value = "/mobile92", method = RequestMethod.GET)
    public String mobile92() {
        return "mobile/mobile92";
    }



}

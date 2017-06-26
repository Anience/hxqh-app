package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/digital")
public class DigitalController {

    @RequestMapping(value = "/digital13", method = RequestMethod.GET)
    public String digital13() {
        return "digital/digital13";
    }

    @RequestMapping(value = "/digital14", method = RequestMethod.GET)
    public String digital14() {
        return "digital/digital14";
    }

    @RequestMapping(value = "/digital17", method = RequestMethod.GET)
    public String digital17() {
        return "digital/digital17";
    }

    @RequestMapping(value = "/digital18", method = RequestMethod.GET)
    public String digital18() {
        return "digital/digital18";
    }

    @RequestMapping(value = "/digital13141718", method = RequestMethod.GET)
    public String digital13141718() {
        return "digital/digital13141718";
    }

    @RequestMapping(value = "/digital1620", method = RequestMethod.GET)
    public String digital1620() {
        return "digital/digital1620";
    }
}

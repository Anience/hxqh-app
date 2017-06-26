package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ano")
public class AnoController {


    @RequestMapping(value = "/ano81", method = RequestMethod.GET)
    public String ano81() {
        return "ano/ano81";
    }

    @RequestMapping(value = "/ano82", method = RequestMethod.GET)
    public String ano82() {
        return "ano/ano82";
    }


}

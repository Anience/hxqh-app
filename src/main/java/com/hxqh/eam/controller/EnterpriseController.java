package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.EnterpriseTopDto;
import com.hxqh.eam.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/enterprise")
@SessionAttributes(value = "sessionInfo")
public class EnterpriseController {


    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * enterprise  government business Top的所有页面跳转
     * 根据show的值控制跳转页面，type回传
     *
     * @return
     */
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public ModelAndView top1(@RequestParam("show") String show,
                             @RequestParam("type") String type) {
        Map<String, Object> result = new HashMap<>();
        result.put("page", type);
        Integer integer = Integer.valueOf(show);
        if (integer == 1) {
            return new ModelAndView("enterprise/top1", result);
        } else if (integer == 2) {
            return new ModelAndView("enterprise/top2", result);
        } else {
            return new ModelAndView("enterprise/top4", result);
        }
    }


    /**
     * enterprise  government business Top1Data 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/top1Data", method = RequestMethod.GET)
    public EnterpriseDto top1Data(@RequestParam("show") Integer show,
                                  @RequestParam("type") String type) {
        EnterpriseDto enterpriseTDto = enterpriseService.getTopData(show, type);
        return enterpriseTDto;
    }


}

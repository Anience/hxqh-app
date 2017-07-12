package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.EnterpriseTopDto;
import com.hxqh.eam.model.dto.GovernmentDto;
import com.hxqh.eam.service.EnterpriseService;
import org.hibernate.event.service.internal.EventListenerServiceInitiator;
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


    @RequestMapping(value = "/enterprise222324B1", method = RequestMethod.GET)
    public String enterprise222324B1() {
        return "enterprise/enterprise222324B1";
    }

    @RequestMapping(value = "/enterprise222324B2", method = RequestMethod.GET)
    public String enterprise222324B2() {
        return "enterprise/enterprise222324B2";
    }

    @RequestMapping(value = "/enterprise222324B4", method = RequestMethod.GET)
    public String enterprise222324B4() {
        return "enterprise/enterprise222324B4";
    }

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
    public EnterpriseTopDto top1Data(@RequestParam("show") String show,
                                     @RequestParam("type") String type) {
        EnterpriseTopDto enterpriseTopDto = enterpriseService.getTopData(show,type);
        return enterpriseTopDto;
    }


    /**
     * bussiness 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "/enterpriseBussiness", method = RequestMethod.GET)
    public String enterpriseBussiness() {
        return "enterprise/entBussiness";
    }


    //TODO 数据有问题  确定横轴长度与空余值补0

    /**
     * bussiness 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bussinessData", method = RequestMethod.GET)
    public BussinessDto bussinessData() {
        BussinessDto bussinessDto = enterpriseService.getbussinessData();
        return bussinessDto;
    }

    //TODO 数据有问题 确定横轴长度与空余值补0

    /**
     * government 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/governmentData", method = RequestMethod.GET)
    public GovernmentDto governmentData() {
        GovernmentDto governmentDto = enterpriseService.getgovernmentData();
        return governmentDto;
    }

    //TODO 数据有问题 确定横轴长度与空余值补0

    /**
     * enterprise 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/enterpriseData", method = RequestMethod.GET)
    public EnterpriseDto enterpriseData() {
        EnterpriseDto enterpriseDto = enterpriseService.getenterpriseData();
        return enterpriseDto;
    }


    @RequestMapping(value = "/enterpriseGovernment", method = RequestMethod.GET)
    public String enterpriseGovernment() {
        return "enterprise/entGover";
    }

    @RequestMapping(value = "/enterpriseEnterprise", method = RequestMethod.GET)
    public String enterpriseEnterprise() {
        return "enterprise/enterprise";
    }

    @RequestMapping(value = "/enterprise262728G1", method = RequestMethod.GET)
    public String enterprise262728G1() {
        return "enterprise/enterprise262728G1";
    }

    @RequestMapping(value = "/enterprise262728G2", method = RequestMethod.GET)
    public String enterprise262728G2() {
        return "enterprise/enterprise262728G2";
    }

    @RequestMapping(value = "/enterprise262728G4", method = RequestMethod.GET)
    public String enterprise262728G4() {
        return "enterprise/enterprise262728G4";
    }

    @RequestMapping(value = "/enterprise303132E1", method = RequestMethod.GET)
    public String enterprise303132E1() {
        return "enterprise/enterprise303132E1";
    }

    @RequestMapping(value = "/enterprise303132E2", method = RequestMethod.GET)
    public String enterprise303132E2() {
        return "enterprise/enterprise303132E2";
    }

    @RequestMapping(value = "/enterprise303132E4", method = RequestMethod.GET)
    public String enterprise303132E4() {
        return "enterprise/enterprise303132E4";
    }


}

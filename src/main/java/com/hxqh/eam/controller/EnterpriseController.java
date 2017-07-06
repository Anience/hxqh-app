package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.GovernmentDto;
import com.hxqh.eam.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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

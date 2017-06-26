package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

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

    @RequestMapping(value = "/enterpriseBussiness", method = RequestMethod.GET)
    public String enterpriseBussiness() {
        return "enterprise/enterpriseBussiness";
    }

    @RequestMapping(value = "/enterpriseGovernment", method = RequestMethod.GET)
    public String enterpriseGovernment() {
        return "enterprise/enterpriseGovernment";
    }

    @RequestMapping(value = "/enterpriseEnterprise", method = RequestMethod.GET)
    public String enterpriseEnterprise() {
        return "enterprise/enterpriseEnterprise";
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

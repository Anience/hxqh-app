package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.WifiDailyDto;
import com.hxqh.eam.model.dto.WifiTrafficTdo;
import com.hxqh.eam.model.view.*;
import com.hxqh.eam.service.WiFiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/wifi")
public class WiFiController {

    @Autowired
    private WiFiService wiFiService;


    /**
     *  wifi Traffic 页面跳转接口
     * @return
     */
    @RequestMapping(value = "/wifi", method = RequestMethod.GET)
    public String wifi() {
        return "wifi/traffic";
    }

    /**
     * vWifiTrafficData 数据接口
     * Access 2017-6-26 11:21:26
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiTrafficData", method = RequestMethod.GET)
    public WifiTrafficTdo vWifiTrafficData() {
        WifiTrafficTdo wifiTrafficTdo = wiFiService.getTrafficData();

        return wifiTrafficTdo;
    }


    /**
     *  number   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String number() {
        return "wifi/number";
    }

    /**
     * vWifiNumberData 数据接口
     * Access 2017-6-26 11:21:40
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiNumberData", method = RequestMethod.GET)
    public List<VWifiNumber> vWifiNumberData() {
        List<VWifiNumber> dig13List = wiFiService.vWifiNumberData();
        return dig13List;
    }

    /**
     *  ticket   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String ticket() {
        return "wifi/ticket";
    }

    /**
     * vWifiTicketData 数据接口
     *  Access 2017-6-26 11:23:07
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiTicketData", method = RequestMethod.GET)
    public List<VWifiTicket> vWifiTicketData() {
        List<VWifiTicket> dig13List = wiFiService.vWifiTicketData();
        return dig13List;
    }


    /**
     *  daily   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String daily() {
        return "wifi/daily";
    }

    /**
     * vWifiDailyData 数据接口
     * Access 2017-6-26 11:23:25
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiDailyData", method = RequestMethod.GET)
    public WifiDailyDto vWifiDailyData() {

        WifiDailyDto dailyDto = wiFiService.vWifiDailyData();
        return dailyDto;
    }

    /**
     *  distribution   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public String distribution() {
        return "wifi/distribution";
    }


    /**
     * vWifiDistributionData 数据接口
     * Access 2017-6-26 11:23:29
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiDistributionData", method = RequestMethod.GET)
    public List<VWifiDistribution> vWifiDistributionData() {
        List<VWifiDistribution> dig13List = wiFiService.vWifiDistributionData();
        return dig13List;
    }

    /**
     *  mttr   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/mttr", method = RequestMethod.GET)
    public String mttr() {
        return "wifi/mttr";
    }

    /**
     * vWifiMttrData 数据接口
     * Access 2017-6-26 11:23:51
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiMttrData", method = RequestMethod.GET)
    public List<VWifiMttr> vWifiMttrData() {
        List<VWifiMttr> dig13List = wiFiService.vWifiMttrData();
        return dig13List;
    }

    /**
     *  monitoring   页面跳转接口
     * @return
     */
    @RequestMapping(value = "/monitoring", method = RequestMethod.GET)
    public String monitoring() {
        return "wifi/monitoring";
    }

    /**
     * vWifiMonitoringData 数据接口
     * Access 2017-6-26 11:24:01
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiMonitoringData", method = RequestMethod.GET)
    public List<VWifiMonitoring> vWifiMonitoringData() {
        List<VWifiMonitoring> dig13List = wiFiService.vWifiMonitoringData();
        return dig13List;
    }

}

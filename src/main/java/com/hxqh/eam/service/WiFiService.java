package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.DailyDto;
import com.hxqh.eam.model.dto.TrafficTdo;
import com.hxqh.eam.model.dto.WifiMttrDto;
import com.hxqh.eam.model.dto.WifiTrafficTdo;
import com.hxqh.eam.model.view.*;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface WiFiService {

    WifiTrafficTdo getTrafficData();

    List<VWifiNumber> vWifiNumberData();

    List<VWifiTicket> vWifiTicketData();

    List<VWifiDistribution> vWifiDistributionData();

    WifiMttrDto vWifiMttrData();

    List<VWifiMonitoring> vWifiMonitoringData();

    DailyDto wifiDailyData();

    TrafficTdo getWifiTrafficData();
}

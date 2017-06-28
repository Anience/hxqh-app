package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.WifiDailyDto;
import com.hxqh.eam.model.dto.WifiTrafficTdo;
import com.hxqh.eam.model.view.*;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface WiFiService {


    public abstract WifiTrafficTdo getTrafficData();

    public abstract List<VWifiNumber> vWifiNumberData();

    public abstract List<VWifiTicket> vWifiTicketData();

    public abstract WifiDailyDto vWifiDailyData();

    public abstract List<VWifiDistribution> vWifiDistributionData();

    public abstract List<VWifiMttr> vWifiMttrData();

    public abstract List<VWifiMonitoring> vWifiMonitoringData();


}

package com.hxqh.eam.service;

import com.hxqh.eam.model.view.*;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface WiFiService {


    public abstract List<VWifiTrafficBottom> vWifiTrafficBottomData();

    public abstract List<VWifiTrafficTop> vWifiTrafficTopData();

    public abstract List<VWifiNumber> vWifiNumberData();

    public abstract List<VWifiTicket> vWifiTicketData();

    public abstract List<VWifiDaily> vWifiDailyData();

    public abstract List<VWifiDistribution> vWifiDistributionData();

    public abstract List<VWifiMttr> vWifiMttrData();

    public abstract List<VWifiMonitoring> vWifiMonitoringData();
}

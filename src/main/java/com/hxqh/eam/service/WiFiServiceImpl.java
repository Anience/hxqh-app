package com.hxqh.eam.service;

import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.WifiTrafficTdo;
import com.hxqh.eam.model.dto.WifiTrafficTopTdo;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("wiFiService")
public class WiFiServiceImpl implements WiFiService {


    private static final String[] TREG = {"TREG 1",
            "TREG 2",
            "TREG 3",
            "TREG 4",
            "TREG 5",
            "TREG 6",
            "TREG 7"};

    private static final String[] CONS = {"CONS",
            "DWS",
            "EBIS"};


    @Autowired
    private VWifiDailyDao vWifiDailyDao;
    @Autowired
    private VWifiDistributionDao vWifiDistributionDao;
    @Autowired
    private VWifiMonitoringDao vWifiMonitoringDao;
    @Autowired
    private VWifiMttrDao vWifiMttrDao;
    @Autowired
    private VWifiNumberDao vWifiNumberDao;
    @Autowired
    private VWifiTicketDao vWifiTicketDao;

    @Autowired
    private VWifiTrafficBottomDao vWifiTrafficBottomDao;
    @Autowired
    private VWifiTrafficTopDao vWifiTrafficTopDao;


    @Override
    public WifiTrafficTdo getTrafficData() {
        List<String> nameTopList = new LinkedList<>();
        List<String> nameBottomList = new LinkedList<>();
        List<WifiTrafficTopTdo> strTop = new LinkedList<>();
        List<WifiTrafficTopTdo> strBottom = new LinkedList<>();

        StringBuilder stringBuilderTop = new StringBuilder(2048);
        StringBuilder stringBuilderBottom = new StringBuilder(2048);

        //先取出全部数据
        List<VWifiTrafficTop> trafficTopList = vWifiTrafficTopDao.findAll();
        List<VWifiTrafficBottom> trafficBottomList = vWifiTrafficBottomDao.findAll();

        topJson(trafficTopList, nameTopList, strTop, stringBuilderTop);
        topBottom(trafficBottomList,nameBottomList,strBottom,stringBuilderBottom);
        WifiTrafficTdo trafficTdo = new WifiTrafficTdo();
        trafficTdo.setNameList(nameTopList);
        trafficTdo.setStrTop(strTop);
        trafficTdo.setNameBottomList(nameBottomList);
        trafficTdo.setStrBottom(strBottom);
        return trafficTdo;
    }

    private void topBottom(List<VWifiTrafficBottom> trafficBottomList, List<String> nameBottomList, List<WifiTrafficTopTdo> strBottom, StringBuilder stringBuilderBottom) {
        int i = 1, j = 0;
        for (int x = 0; x < trafficBottomList.size(); x++) {
            stringBuilderBottom.append(trafficBottomList.get(x).getCount()).append(",");
            if (i % 26 == 0) {
                String str = stringBuilderBottom.toString();
                str = dealJson(str);
                WifiTrafficTopTdo topTdo = new WifiTrafficTopTdo(CONS[j], str);
                strBottom.add(topTdo);
                stringBuilderBottom = new StringBuilder(2048);
                j++;
            }
            i++;
        }

        for (int x = 0; x < 26; x++) {
            nameBottomList.add(trafficBottomList.get(x).getName());
        }

    }

    private void topJson(List<VWifiTrafficTop> trafficTopList, List<String> nameList, List<WifiTrafficTopTdo> strTop, StringBuilder stringBuilder) {
        int i = 1, j = 0;
        for (int x = 0; x < trafficTopList.size(); x++) {
            stringBuilder.append(trafficTopList.get(x).getCount()).append(",");

            if (i % 26 == 0) {
                String str = stringBuilder.toString();
                str = dealJson(str);
                WifiTrafficTopTdo topTdo = new WifiTrafficTopTdo(TREG[j], str);
                strTop.add(topTdo);
                stringBuilder = new StringBuilder(2048);
                j++;
            }
            i++;
        }

        for (int x = 0; x < 26; x++) {
            nameList.add(trafficTopList.get(x).getName());
        }
    }

    private String dealJson(String str) {
        String substring = str.substring(0, str.length() - 1);
        return substring;
    }

    @Override
    public List<VWifiNumber> vWifiNumberData() {
        return vWifiNumberDao.findAll();
    }

    @Override
    public List<VWifiTicket> vWifiTicketData() {
        return vWifiTicketDao.findAll();
    }

    @Override
    public List<VWifiDaily> vWifiDailyData() {
        return vWifiDailyDao.findAll();
    }

    @Override
    public List<VWifiDistribution> vWifiDistributionData() {
        return vWifiDistributionDao.findAll();
    }

    @Override
    public List<VWifiMttr> vWifiMttrData() {
        return vWifiMttrDao.findAll();
    }

    @Override
    public List<VWifiMonitoring> vWifiMonitoringData() {
        return vWifiMonitoringDao.findAll();
    }
}

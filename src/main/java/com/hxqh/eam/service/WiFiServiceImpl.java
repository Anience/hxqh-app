package com.hxqh.eam.service;

import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("wiFiService")
public class WiFiServiceImpl implements WiFiService {


    private static final String[] TREG = {
            "TREG 1",
            "TREG 2",
            "TREG 3",
            "TREG 4",
            "TREG 5",
            "TREG 6",
            "TREG 7"};

    private static final String[] CONS = {"CONS", "DWS", "EBIS"};

    private static final String[] DAILY = {"DCS", "DES", "DGS"};

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

    @Autowired
    private VWifiMttrListDao vWifiMttrListDao;

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
        topBottom(trafficBottomList, nameBottomList, strBottom, stringBuilderBottom);

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
    public List<VWifiDistribution> vWifiDistributionData() {
        return vWifiDistributionDao.findAll();
    }

    @Override
    public WifiMttrDto vWifiMttrData() {
        List<VWifiMttr> wifiMttrList = vWifiMttrDao.findAll();
        List<VWifiMttrList> mttrListList = vWifiMttrListDao.findAll();
        WifiMttrDto mttrDto = new WifiMttrDto(wifiMttrList, mttrListList);
        return mttrDto;
    }

    @Override
    public List<VWifiMonitoring> vWifiMonitoringData() {
        return vWifiMonitoringDao.findAll();
    }

    @Override
    public DailyDto wifiDailyData() {
        List<VWifiDaily> dailyList = vWifiDailyDao.findAll();

        List<String> list = new LinkedList<>();
        for (int x = 0; x < 4; x++) {
            list.add(dailyList.get(x).getName());
        }

        /* 分组算法**/
        Map<String, List<BigDecimal>> skuIdMap = new HashMap<>();
        for (VWifiDaily skuVo : dailyList) {
            List<BigDecimal> tempList = skuIdMap.get(skuVo.getDa());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            groupList(skuIdMap, tempList, skuVo.getCount(), skuVo.getDa());
        }

        //补零
        List<BigDecimal> des = skuIdMap.get(DAILY[2]);
        if(des.size()<4)
        {
            int i = 4-des.size();
            for (int j=0;j<i;j++)
            {
                des.add(new BigDecimal(0));
            }
            skuIdMap.put(DAILY[2],des);
        }

        DailyDto dailyDto = new DailyDto(skuIdMap, list);
        return dailyDto;
    }

    @Override
    public TrafficTdo getWifiTrafficData() {
        //先取出全部数据
        List<VWifiTrafficTop> trafficTopList = vWifiTrafficTopDao.findAll();
        List<VWifiTrafficBottom> trafficBottomList = vWifiTrafficBottomDao.findAll();


        List<String> nameList = new LinkedList<>();
        for (int x = 0; x < 26; x++) {
            nameList.add(trafficTopList.get(x).getName());
        }

         /* 分组算法**/
        Map<String, List<BigDecimal>> topMap = new HashMap<>();
        for (VWifiTrafficTop skuVo : trafficTopList) {
            List<BigDecimal> tempList = topMap.get(skuVo.getDa());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            groupList(topMap, tempList, skuVo.getCount(), skuVo.getDa());
        }

        Map<String, List<BigDecimal>> bottomMap = new HashMap<>();
        for (VWifiTrafficBottom skuVo : trafficBottomList) {
            List<BigDecimal> tempList = bottomMap.get(skuVo.getDa());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            groupList(bottomMap, tempList, skuVo.getCount(), skuVo.getDa());
        }
        TrafficTdo trafficTdo = new TrafficTdo(nameList, topMap, bottomMap);
        return trafficTdo;
    }

    private void groupList(Map<String, List<BigDecimal>> skuIdMap, List<BigDecimal> tempList, BigDecimal count, String da) {
        if (tempList == null) {
            tempList = new LinkedList<>();
            tempList.add(count);
            skuIdMap.put(da, tempList);
        } else {
        /*某个sku之前已经存放过了,则直接追加数据到原来的List里**/
            tempList.add(count);
        }
    }
}

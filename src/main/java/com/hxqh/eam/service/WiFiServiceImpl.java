package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.DailyDto;
import com.hxqh.eam.model.dto.TrafficTdo;
import com.hxqh.eam.model.dto.WifiMttrDto;
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

    private static final String[] DAILY = {"DCS", "DES", "DGS"};

    private static final int DAILYLENGTH = 4;

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

        // mttrListList进行分组
        Map<String, List<VWifiMttrList>> map = GroupListUtil.group(mttrListList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VWifiMttrList d = (VWifiMttrList) obj;
                return d.getIoc1();    // 分组依据为Ioc1
            }
        });

        Map<String, List<VWifiMttrList>> leftList = new LinkedHashMap<>() ;
        Map<String, List<VWifiMttrList>> rightList = new LinkedHashMap<>();
        //拆分Map
        int i = 0;
        for (Map.Entry m : map.entrySet()) {
            if (map.size() / 2 > i) {
                leftList.put((String)m.getKey(),(List<VWifiMttrList>)m.getValue());
                i++;
            } else {
                rightList.put((String)m.getKey(),(List<VWifiMttrList>)m.getValue());
                i++;
            }
        }

        // wifiMttrList进行分组
        Map<String, List<VWifiMttr>> mttrMap = GroupListUtil.group(wifiMttrList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VWifiMttr d = (VWifiMttr) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });


        Map<String, List<BigDecimal>> mttrM = new LinkedHashMap<>();
        for(Map.Entry<String, List<VWifiMttr>> m:mttrMap.entrySet())
        {
            List<BigDecimal> mttrs = new LinkedList<>();
            for(VWifiMttr l:m.getValue())
            {
                mttrs.add(l.getCount());
            }
            mttrM.put(m.getKey(),mttrs);
        }

        WifiMttrDto mttrDto = new WifiMttrDto(mttrM, leftList,rightList);
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
        for (int x = 0; x < DAILYLENGTH; x++) {
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
        if (des.size() < DAILYLENGTH) {
            int i = DAILYLENGTH - des.size();
            for (int j = 0; j < i; j++) {
                des.add(new BigDecimal(0));
            }
            skuIdMap.put(DAILY[2], des);
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

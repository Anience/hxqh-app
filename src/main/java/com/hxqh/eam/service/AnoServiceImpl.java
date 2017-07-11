package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.IndiHomeDto;
import com.hxqh.eam.model.dto.OpenMapLinesDto;
import com.hxqh.eam.model.dto.OpenMapTableDto;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Service("anoService")
public class AnoServiceImpl implements AnoService {

    @Autowired
    private VAno81Dao vAno81Dao;
    @Autowired
    private VAno82Dao ano82Dao;
    @Autowired
    private VHomeImpactDao homeImpactDao;
    @Autowired
    private VHomeRegularDao homeRegularDao;
    @Autowired
    private VHomeTotalDao homeTotalDao;
    @Autowired
    private VMapOpenmaplineDao mapOpenmaplineDao;
    @Autowired
    private VMapOpenmaplinesLinecolorDao mapOpenmaplinesLinecolorDao;
    @Autowired
    private VMapOpenmappointDao mapOpenmappointDao;
    @Autowired
    private VMapOpenmaptableDao mapOpenmaptableDao;
    @Autowired
    private VMapOpenmaptableRighttableDao mapOpenmaptableRighttableDao;

    @Override
    public List<VAno81> getAno81Data() {
        return vAno81Dao.findAll();
    }

    @Override
    public List<VAno82> getAno82Data() {
        return ano82Dao.findAll();
    }


    @Override
    public IndiHomeDto getIndiHomeData() {
        List<VHomeImpact> homeImpact = homeImpactDao.findAll();
        List<VHomeRegular> homeRegular = homeRegularDao.findAll();
        List<VHomeTotal> homeTotal = homeTotalDao.findAll();

        IndiHomeDto indiHomeDto = new IndiHomeDto(homeImpact, homeRegular, homeTotal);
        return indiHomeDto;
    }

    @Override
    public List<VMapOpenmappoint> getOpenMapPointsList() {
        LinkedHashMap<String ,String> linkedHashMap=new LinkedHashMap();
        linkedHashMap.put("type","asc");
        return mapOpenmappointDao.findAll(null,null,linkedHashMap);
    }

    @Override
    public OpenMapLinesDto getOpenMapLinesData() {
        List<VMapOpenmapline> mapOpenmapline = mapOpenmaplineDao.findAll();
        List<VMapOpenmaplinesLinecolor> mapOpenmaplinesLinecolor = mapOpenmaplinesLinecolorDao.findAll();
        OpenMapLinesDto mapLinesDto = new OpenMapLinesDto(mapOpenmapline, mapOpenmaplinesLinecolor);
        return mapLinesDto;
    }

    @Override
    public OpenMapTableDto getOpenMapTableData() {
        List<VMapOpenmaptable> mapOpenmaptable = mapOpenmaptableDao.findAll();
        List<VMapOpenmaptableRighttable> mapOpenmaptableRighttable = mapOpenmaptableRighttableDao.findAll();
        //对mapOpenmaptable分组
        Map<String, List<VMapOpenmaptable>> mapOpenmaptableMap = GroupListUtil.group(mapOpenmaptable, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VMapOpenmaptable d = (VMapOpenmaptable) obj;
                return d.getType();    // 分组依据为Type
            }
        });
        Map<BigDecimal, List<VMapOpenmaptable>> tregMap = GroupListUtil.group(mapOpenmaptable, new GroupListUtil.GroupBy<BigDecimal>() {
            @Override
            public BigDecimal groupby(Object obj) {
                VMapOpenmaptable d = (VMapOpenmaptable) obj;
                return d.getTreg();    // 分组依据为Treg
            }
        });


        Map<String, List<BigDecimal>> mttrM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VMapOpenmaptable>> m : mapOpenmaptableMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VMapOpenmaptable l : m.getValue()) {
                mttrs.add(l.getNum());
            }
            mttrM.put(m.getKey(), mttrs);
        }
        Map<BigDecimal, List<BigDecimal>> tregM = new LinkedHashMap<>();
        for (Map.Entry<BigDecimal, List<VMapOpenmaptable>> m : tregMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VMapOpenmaptable l : m.getValue()) {
                mttrs.add(l.getNum());
            }
            tregM.put(m.getKey(), mttrs);
        }


        //对mttrM各组求和
        for (Map.Entry<String, List<BigDecimal>> m : mttrM.entrySet()) {
            BigDecimal sum = new BigDecimal(0);
            for(BigDecimal b:m.getValue())
            {
                sum=sum.add(b);
            }
            List<BigDecimal> value = m.getValue();
            value.add(sum);
            mttrM.put(m.getKey(),value);
        }

        List<BigDecimal> columnSum =new  LinkedList<>();
        for (Map.Entry<BigDecimal, List<BigDecimal>> m : tregM.entrySet()) {
            BigDecimal sumCol = new BigDecimal(0);
            for(BigDecimal b:m.getValue())
            {
                sumCol=sumCol.add(b);
            }
            columnSum.add(sumCol);
        }

        //对columnSum求和
        BigDecimal sumCol = new BigDecimal(0);
        for(BigDecimal b:columnSum)
        {
            sumCol=sumCol.add(b);
        }
        columnSum.add(sumCol);

        mttrM.put("columnSum",columnSum);

        OpenMapTableDto openMapTableDto = new OpenMapTableDto(mttrM, mapOpenmaptableRighttable);
        return openMapTableDto;
    }

}

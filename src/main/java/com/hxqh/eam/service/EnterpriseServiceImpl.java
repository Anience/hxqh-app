package com.hxqh.eam.service;


import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.GovernmentDto;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by lh on 2017-6-27 .
 */
@Transactional
@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {


    @Autowired
    private VEntProactiveDao entProactiveDao;

    @Autowired
    private VEntProactivetktDao entProactivetktDao;

    @Autowired
    private VEntReactiveDao entReactiveDao;

    @Autowired
    private VEntReactivetktDao entReactivetktDao;

    @Autowired
    private VGovProactiveDao govProactiveDao;

    @Autowired
    private VGovProactivetktDao govProactivetktDao;

    @Autowired
    private VGovReactiveDao govReactiveDao;

    @Autowired
    private VGovReactivetktDao govReactivetktDao;

    @Autowired
    private VBusProactiveDao busProactiveDao;

    @Autowired
    private VBusProactivetktDao busProactivetktDao;

    @Autowired
    private VBusReactiveDao busReactiveDao;

    @Autowired
    private VBusReactivetktDao busReactivetktDao;


    @Override
    public BussinessDto getbussinessData() {
        List<VBusProactive> busProactive = busProactiveDao.findAll();
        List<VBusReactive> busReactive = busReactiveDao.findAll();

        List<VBusProactivetkt> busProactivetkt = busProactivetktDao.findAll();
        List<VBusReactivetkt> busReactivetkt = busReactivetktDao.findAll();

        // busProactivetkt
        Map<String, List<VBusProactivetkt>> busProactivetktMap = GroupListUtil.group(busProactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VBusProactivetkt d = (VBusProactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });
        // busReactivetkt
        Map<String, List<VBusReactivetkt>> busReactivetktMap = GroupListUtil.group(busReactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VBusReactivetkt d = (VBusReactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });

        Map<String, List<BigDecimal>> busProactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VBusProactivetkt>> m : busProactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VBusProactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            busProactivetktM.put(m.getKey(), mttrs);
        }

        Map<String, List<BigDecimal>> busReactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VBusReactivetkt>> m : busReactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VBusReactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            busReactivetktM.put(m.getKey(), mttrs);
        }

        BussinessDto bussinessDto = new BussinessDto(busProactive, busReactive, busProactivetktM, busReactivetktM);
        return bussinessDto;
    }

    @Override
    public GovernmentDto getgovernmentData() {
        List<VGovProactive> govProactive = govProactiveDao.findAll();
        List<VGovReactive> govReactive = govReactiveDao.findAll();

        List<VGovProactivetkt> govProactivetkt =govProactivetktDao.findAll();
        List<VGovReactivetkt> govReactivetkt = govReactivetktDao.findAll();

        // govProactivetkt
        Map<String, List<VGovProactivetkt>> govProactivetktMap = GroupListUtil.group(govProactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VGovProactivetkt d = (VGovProactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });

        // govReactivetkt
        Map<String, List<VGovReactivetkt>> govReactivetktMap = GroupListUtil.group(govReactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VGovReactivetkt d = (VGovReactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });

        Map<String, List<BigDecimal>> govProactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VGovProactivetkt>> m : govProactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VGovProactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            govProactivetktM.put(m.getKey(), mttrs);
        }

        Map<String, List<BigDecimal>> govReactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VGovReactivetkt>> m : govReactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VGovReactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            govReactivetktM.put(m.getKey(), mttrs);
        }
        GovernmentDto governmentDto = new GovernmentDto(govProactive, govReactive, govProactivetktM, govReactivetktM);
        return governmentDto;
    }

    @Override
    public EnterpriseDto getenterpriseData() {
        List<VEntProactive> entProactive = entProactiveDao.findAll();
        List<VEntReactive> entReactive = entReactiveDao.findAll();

        List<VEntProactivetkt> entProactivetkt = entProactivetktDao.findAll();
        List<VEntReactivetkt> entReactivetkt = entReactivetktDao.findAll();

        // entProactivetkt
        Map<String, List<VEntProactivetkt>> entProactivetktMap = GroupListUtil.group(entProactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VEntProactivetkt d = (VEntProactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });
        // entReactivetkt
        Map<String, List<VEntReactivetkt>> entReactivetktMap = GroupListUtil.group(entReactivetkt, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VEntReactivetkt d = (VEntReactivetkt) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });


        Map<String, List<BigDecimal>> entProactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VEntProactivetkt>> m : entProactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VEntProactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            entProactivetktM.put(m.getKey(), mttrs);
        }

        Map<String, List<BigDecimal>> entReactivetktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VEntReactivetkt>> m : entReactivetktMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VEntReactivetkt l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            entReactivetktM.put(m.getKey(), mttrs);
        }

        EnterpriseDto enterpriseDto = new EnterpriseDto(entProactive, entReactive, entProactivetktM, entReactivetktM);
        return enterpriseDto;
    }
}

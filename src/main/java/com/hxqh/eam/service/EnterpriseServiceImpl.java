package com.hxqh.eam.service;


import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.EnterpriseTopDto;
import com.hxqh.eam.model.dto.GovernmentDto;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    private VEnterpriseTicketDao vEnterpriseTicketDao;

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

        List<VGovProactivetkt> govProactivetkt = govProactivetktDao.findAll();
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

    @Override
    public EnterpriseTopDto getTopData(String show, String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("rightnow", "RIGHTNOW");
        params.put("roactive", "PROACTIVE");
        params.put("type", type);

        String where1 = " source_type=:rightnow and customer_segment=:type ";
        String where2 = " source_type=:roactive and customer_segment=:type ";

        String rightnowWhere, roactiveWhere;
        Integer integer = Integer.valueOf(show);
        if (integer == 1) {
            params.put("custrank", 1);
            rightnowWhere = where1 + "and custrank=:custrank";
            roactiveWhere = where2 + "and custrank=:custrank";
        } else if (integer == 2) {
            String rank2 = "and (custrank=:custrank2 or custrank=:custrank3)";
            params.put("custrank2", 2);
            params.put("custrank3", 3);
            rightnowWhere = where1 + rank2;
            roactiveWhere = where2 + rank2;
        } else {
            params.put("custrank4", 4);
            params.put("custrank5", 5);
            params.put("custrank6", 6);
            params.put("custrank7", 7);
            String rank4 = "and (custrank=:custrank4 or custrank=:custrank5 or custrank=:custrank6 or custrank=:custrank7)";
            rightnowWhere = where1 + rank4;
            roactiveWhere = where2 + rank4;
        }

        List<VEnterpriseTicket> rightnowList = vEnterpriseTicketDao.findAll(rightnowWhere, params, null);
        List<VEnterpriseTicket> proactiveList = vEnterpriseTicketDao.findAll(roactiveWhere, params, null);
        EnterpriseTopDto enterpriseTopDto = new EnterpriseTopDto(rightnowList, proactiveList);
        return enterpriseTopDto;
    }
}

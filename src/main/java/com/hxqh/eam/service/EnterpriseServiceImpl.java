package com.hxqh.eam.service;


import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.VEnterpriseTicketDao;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.EnterpriseTopDto;
import com.hxqh.eam.model.sqlquery.EnterpriseKTK;
import com.hxqh.eam.model.view.VEnterpriseTicket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by lh on 2017-6-27 .
 */
@Transactional
@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private VEnterpriseTicketDao vEnterpriseTicketDao;

    @Override
    public EnterpriseDto getTopData(Integer show, String type) {

        //查询左侧RIGHTNOW PROACTIVE
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("rightnow", "RIGHTNOW");
        params.put("roactive", "PROACTIVE");
        params.put("type", type);

        String where1 = " source_type=:rightnow and customer_segment=:type ";
        String where2 = " source_type=:roactive and customer_segment=:type ";

        String rightnowWhere, roactiveWhere;
        Integer integer = Integer.valueOf(show);

        //实现方法返回一个list，其中有2个或者多个对象EnterpriseTopDto
        if (integer == 1) {
            params.put("custrank", 1);
            rightnowWhere = where1 + "and custrank=:custrank";
            roactiveWhere = where2 + "and custrank=:custrank";
            //处理一个Dto

            EnterpriseTopDto enterpriseTopDto = generateEnterpriseDto(show, type, params, rightnowWhere, roactiveWhere);
            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            enterpriseMap.put(String.valueOf(integer), enterpriseTopDto);
            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);
            return enterpriseDto;
        } else if (integer == 2) {
            //处理两个Dto
            String rank2 = "and (custrank=:custrank2 or custrank=:custrank3)";
            params.put("custrank2", 2);
            params.put("custrank3", 3);
            rightnowWhere = where1 + rank2;
            roactiveWhere = where2 + rank2;
            return null;
        } else {
            params.put("custrank4", 4);
            params.put("custrank5", 5);
            params.put("custrank6", 6);
            params.put("custrank7", 7);
            String rank4 = "and (custrank=:custrank4 or custrank=:custrank5 or custrank=:custrank6 or custrank=:custrank7)";
            rightnowWhere = where1 + rank4;
            roactiveWhere = where2 + rank4;
            return null;
        }
    }

    private EnterpriseTopDto generateEnterpriseDto(Integer show, String type, Map<String, Object> params, String rightnowWhere, String roactiveWhere) {
        List<VEnterpriseTicket> rightnowList = vEnterpriseTicketDao.findAll(rightnowWhere, params, null);
        List<VEnterpriseTicket> proactiveList = vEnterpriseTicketDao.findAll(roactiveWhere, params, null);

        // 1.查询KTK
        String sqlrightnowSql = "select tbe.echars_id as rn, tbe.echars_lable as mon, tbe.echars_legend as regional,nvl(countval,0) as countval from tb_ioc_config_echars tbe left join \n" +
                "(select tkt.* from  tb_ioc_data_bgew_ticket_tkt tkt where tkt.customer_segment = :CUSTOMERSEGMENT and  tkt.sourcetype=:SOURCETYPE and tkt.custrank =:custrank) rs\n" +
                "on tbe.echars_lable = rs.mon and tbe.echars_legend = rs.regional order by tbe.echars_id";
        List<EnterpriseKTK> rightnowTicketTktList = sessionFactory.getCurrentSession().createSQLQuery(sqlrightnowSql).addEntity(EnterpriseKTK.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "RIGHTNOW").setString("custrank", String.valueOf(show)).list();


        String sqlproactiveSql = "select tbe.echars_id as rn, tbe.echars_lable as mon, tbe.echars_legend as regional,nvl(countval,0) as countval from tb_ioc_config_echars tbe left join \n" +
                "(select tkt.* from  tb_ioc_data_bgew_ticket_tkt tkt where tkt.customer_segment = :CUSTOMERSEGMENT and  tkt.sourcetype=:SOURCETYPE and tkt.custrank =:custrank) rs\n" +
                "on tbe.echars_lable = rs.mon and tbe.echars_legend = rs.regional order by tbe.echars_id";
        List<EnterpriseKTK> proactiveTicketTktList1 = sessionFactory.getCurrentSession().createSQLQuery(sqlproactiveSql).addEntity(EnterpriseKTK.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "PROACTIVE").setString("custrank", String.valueOf(show)).list();

        // 2.rightnow 和 proactive 的nameList
        HashMap<String, String> rightnowNameMap = new LinkedHashMap<>();
        for (EnterpriseKTK top : rightnowTicketTktList) {
            String name = top.getMon();
            rightnowNameMap.put(name, name);
        }
        List<String> rightnowNameList = new LinkedList<>();
        for (String key : rightnowNameMap.keySet()) {
            rightnowNameList.add(rightnowNameMap.get(key));
        }

        HashMap<String, String> proactiveNameMap = new LinkedHashMap<>();
        for (EnterpriseKTK top : proactiveTicketTktList1) {
            String name = top.getMon();
            proactiveNameMap.put(name, name);
        }
        List<String> proactiveNameList = new LinkedList<>();
        for (String key : proactiveNameMap.keySet()) {
            proactiveNameList.add(proactiveNameMap.get(key));
        }

        // 4.对rightnowTicketTktList分组
        Map<String, List<EnterpriseKTK>> rightnowTicketMap = GroupListUtil.group(rightnowTicketTktList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKTK d = (EnterpriseKTK) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        //对proactiveTicketTktList1分组
        Map<String, List<EnterpriseKTK>> proactiveTicketMap = GroupListUtil.group(rightnowTicketTktList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                EnterpriseKTK d = (EnterpriseKTK) obj;
                return d.getRegional();    // 分组依据为Regional
            }
        });

        return new EnterpriseTopDto(rightnowList, proactiveList, rightnowNameList, proactiveNameList, rightnowTicketMap, proactiveTicketMap);
    }


    //查询分组结果
    //开始获取条形图数据   RIGHTNOW  PROACTIVE_TICKET
//    String sqlrightnow = " select u.*,rownum rn  from (select t.MON, t.REGIONAL, sum(t.COUNTVAL) as COUNTVAL from V_ENTERPRISE_TICKET_TKT t " +
//            "where t.CUSTOMER_SEGMENT =:CUSTOMERSEGMENT and t.SOURCETYPE=:SOURCETYPE group by t.MON, t.REGIONAL) u";
//   List<EnterpriseKTK> list = sessionFactory.getCurrentSession().createSQLQuery(sqlrightnow).
//            addEntity(EnterpriseKTK.class).setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE","RIGHTNOW").list();

}

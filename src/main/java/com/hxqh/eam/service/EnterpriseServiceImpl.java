package com.hxqh.eam.service;


import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.VEnterpriseTicketDao;
import com.hxqh.eam.model.dto.*;
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
            String rank2 = "and (custrank=:custrank2)";
            String rank3 = "and (custrank=:custrank3)";
            params.put("custrank2", 2);
            params.put("custrank3", 3);

            String rightnowWhere2, roactiveWhere2, rightnowWhere3, roactiveWhere3;
            rightnowWhere2 = where1 + rank2;
            roactiveWhere2 = where2 + rank2;
            rightnowWhere3 = where1 + rank3;
            roactiveWhere3 = where2 + rank3;

            EnterpriseTopDto enterpriseTopDto2 = generateEnterpriseDto(show, type, params, rightnowWhere2, roactiveWhere2);
            EnterpriseTopDto enterpriseTopDto3 = generateEnterpriseDto(show, type, params, rightnowWhere3, roactiveWhere3);
            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            enterpriseMap.put(String.valueOf(integer), enterpriseTopDto2);
            enterpriseMap.put(String.valueOf(integer + 1), enterpriseTopDto3);

            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);
            return enterpriseDto;
        } else {
            String rank4 = "and (custrank=:custrank4)";
            String rank5 = "and (custrank=:custrank5)";
            String rank6 = "and (custrank=:custrank6)";
            String rank7 = "and (custrank=:custrank7)";
            params.put("custrank4", 4);
            params.put("custrank5", 5);
            params.put("custrank6", 6);
            params.put("custrank7", 7);

            String rightnowWhere4, roactiveWhere4, rightnowWhere5, roactiveWhere5, rightnowWhere6, roactiveWhere6, rightnowWhere7, roactiveWhere7;
            rightnowWhere4 = where1 + rank4;
            roactiveWhere4 = where2 + rank4;
            rightnowWhere5 = where1 + rank5;
            roactiveWhere5 = where2 + rank5;
            rightnowWhere6 = where1 + rank6;
            roactiveWhere6 = where2 + rank6;
            rightnowWhere7 = where1 + rank7;
            roactiveWhere7 = where2 + rank7;
            EnterpriseTopDto enterpriseTopDto4 = generateEnterpriseDto(show, type, params, rightnowWhere4, roactiveWhere4);
            EnterpriseTopDto enterpriseTopDto5 = generateEnterpriseDto(show, type, params, rightnowWhere5, roactiveWhere5);
            EnterpriseTopDto enterpriseTopDto6 = generateEnterpriseDto(show, type, params, rightnowWhere6, roactiveWhere6);
            EnterpriseTopDto enterpriseTopDto7 = generateEnterpriseDto(show, type, params, rightnowWhere7, roactiveWhere7);
            Map<String, EnterpriseTopDto> enterpriseMap = new HashMap<>();
            enterpriseMap.put(String.valueOf(integer), enterpriseTopDto4);
            enterpriseMap.put(String.valueOf(integer + 1), enterpriseTopDto5);
            enterpriseMap.put(String.valueOf(integer + 2), enterpriseTopDto6);
            enterpriseMap.put(String.valueOf(integer + 3), enterpriseTopDto7);

            EnterpriseDto enterpriseDto = new EnterpriseDto(enterpriseMap);
            return enterpriseDto;
        }
    }

    private EnterpriseTopDto generateEnterpriseDto(Integer show, String type, Map<String, Object> params, String rightnowWhere, String roactiveWhere) {
        List<VEnterpriseTicket> rightnowList = vEnterpriseTicketDao.findAll(rightnowWhere, params, null);
        List<VEnterpriseTicket> proactiveList = vEnterpriseTicketDao.findAll(roactiveWhere, params, null);

        // 1.查询KTK
        String sqlrightnowSql = "select tbe.echars_id as rn, tbe.echars_lable as mon, tbe.echars_legend as regional,nvl(countval,0) as countval from tb_ioc_config_echars tbe left join \n" +
                "(select mon,regional,sum(countval) as countval from  tb_ioc_data_bgew_ticket_tkt tkt where tkt.customer_segment = :CUSTOMERSEGMENT and  tkt.sourcetype=:SOURCETYPE and tkt.custrank =:custrank group by mon,regional) rs\n" +
                "on tbe.echars_lable = rs.mon and tbe.echars_legend = rs.regional and  tbe.ECHARS_TYPE = 'BEFORE30DAYS' order by tbe.echars_id";
        List<EnterpriseKTK> rightnowTicketTktList = sessionFactory.getCurrentSession().createSQLQuery(sqlrightnowSql).addEntity(EnterpriseKTK.class).
                setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE", "RIGHTNOW").setString("custrank", String.valueOf(show)).list();


        String sqlproactiveSql = "select tbe.echars_id as rn, tbe.echars_lable as mon, tbe.echars_legend as regional,nvl(countval,0) as countval from tb_ioc_config_echars tbe left join \n" +
                "(select mon,regional,sum(countval) as countval from  tb_ioc_data_bgew_ticket_tkt tkt where tkt.customer_segment = :CUSTOMERSEGMENT and  tkt.sourcetype=:SOURCETYPE and tkt.custrank =:custrank group by mon,regional) rs\n" +
                "on tbe.echars_lable = rs.mon and tbe.echars_legend = rs.regional and  tbe.ECHARS_TYPE = 'BEFORE30DAYS' order by tbe.echars_id";
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

        Map<String, List<Integer>> rightnowTicketM = new LinkedHashMap<>();
        extractNumberList(rightnowTicketMap, rightnowTicketM);

        Map<String, List<Integer>> proactiveTicketM = new LinkedHashMap<>();
        extractNumberList(proactiveTicketMap, proactiveTicketM);

        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/
        String scolorSql = "select t.customer_sement as cust,sum(t.gt) as gt,sum(t.eq) as eq,sum(t.lt) as lt from TB_IOC_DATA_BGEW_SLA t " +
                "where t.customer_sement =:CUSTOMERSEGMENT and t.custrank =:custrank  group by t.customer_sement";
        List<EnterpriseThreeColor> colorList = sessionFactory.getCurrentSession().createSQLQuery(scolorSql).addEntity(EnterpriseThreeColor.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        EnterpriseThreeColor threeColor = new EnterpriseThreeColor();
        if (colorList.size() > 0) {
            threeColor = colorList.get(0);
        }
        /*************************************右上角 TB_IOC_DATA_BGEW_SLA   三色*****************************/


        /*************************************select * from tb_ioc_cust_top7 显示名称*****************************/
        String nameSql = "select t.custname as cname from tb_ioc_cust_top7 t where  t.custtype =:CUSTOMERSEGMENT and t.custrank =:custrank";
        List<NameDto> nameList = sessionFactory.getCurrentSession().createSQLQuery(nameSql).addEntity(NameDto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        String name = new String();
        if (nameList.size() > 0) {
            name = nameList.get(0).getCname();
        }

        /*************************************select * from tb_ioc_cust_top7 显示名称*****************************/

        /*************************************TB_IOC_ENT_CUST_SERVICE   左下角显示图标*****************************/
        String iconSql = "select t.service_lay as lay,t.status from TB_IOC_ENT_CUST_SERVICE t  where t.cust_type = :CUSTOMERSEGMENT and t.cust_rank =:custrank";
        List<EnterpriseIconDto> iconList = sessionFactory.getCurrentSession().createSQLQuery(iconSql).addEntity(EnterpriseIconDto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************TB_IOC_ENT_CUST_SERVICE   左下角显示图标*****************************/

        /*************************************event*****************************/
        String eventSql = "select t.service_affecting as affevent,rownum rn  from TB_IOC_ENT_CUST_EVENT t where t.cust_type = :CUSTOMERSEGMENT and t.cust_rank = :custrank and rownum<4";
        List<EnterpriseEventDto> eventList = sessionFactory.getCurrentSession().createSQLQuery(eventSql).addEntity(EnterpriseEventDto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************event*****************************/

        /*************************************6:Tb_Ioc_Ent_Bge_Region*****************************/
        String enter6SQL = "select u.*,rownum rn  from (select t.treg ,t.time_data as timedata,sum(t.sum_persion_in) as personsum from Tb_Ioc_Ent_Bge_Region t " +
                "where t.cust_type = :CUSTOMERSEGMENT and t.custrank = :custrank  group by t.treg,t.time_data order by t.time_data asc) u";
        List<Enterprise67Dto> dto6List = sessionFactory.getCurrentSession().createSQLQuery(enter6SQL).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************6:Tb_Ioc_Ent_Bge_Region*****************************/


        /*************************************7:TB_IOC_ENT_BGE_PRODUCT*****************************/
        String enter7SQL = "select u.*,rownum rn  from (select t.cust_type as treg,t.data_times as timedata,sum(t.sum_in) as personsum  from TB_IOC_ENT_BGE_PRODUCT t " +
                "where t.cust_type = :CUSTOMERSEGMENT and t.custrank = :custrank  group by t.cust_type,t.data_times order by t.data_times asc) u";
        List<Enterprise67Dto> dto7List = sessionFactory.getCurrentSession().createSQLQuery(enter7SQL).addEntity(Enterprise67Dto.class).
                setString("CUSTOMERSEGMENT", type).setString("custrank", String.valueOf(show)).list();
        /*************************************7:TB_IOC_ENT_BGE_PRODUCT*****************************/

        return new EnterpriseTopDto(rightnowList, proactiveList, rightnowNameList, proactiveNameList, rightnowTicketM, proactiveTicketM, threeColor, name, iconList, eventList, dto6List, dto7List);
    }

    private void extractNumberList(Map<String, List<EnterpriseKTK>> proactiveTicketMap, Map<String, List<Integer>> proactiveTicketM) {
        for (Map.Entry<String, List<EnterpriseKTK>> m : proactiveTicketMap.entrySet()) {
            List<Integer> mttrs = new LinkedList<>();
            for (EnterpriseKTK l : m.getValue()) {
                mttrs.add(l.getCountval());
            }
            proactiveTicketM.put(m.getKey(), mttrs);
        }
    }


    //查询分组结果
    //开始获取条形图数据   RIGHTNOW  PROACTIVE_TICKET
//    String sqlrightnow = " select u.*,rownum rn  from (select t.MON, t.REGIONAL, sum(t.COUNTVAL) as COUNTVAL from V_ENTERPRISE_TICKET_TKT t " +
//            "where t.CUSTOMER_SEGMENT =:CUSTOMERSEGMENT and t.SOURCETYPE=:SOURCETYPE group by t.MON, t.REGIONAL) u";
//   List<EnterpriseKTK> list = sessionFactory.getCurrentSession().createSQLQuery(sqlrightnow).
//            addEntity(EnterpriseKTK.class).setString("CUSTOMERSEGMENT", type).setString("SOURCETYPE","RIGHTNOW").list();

}

package com.hxqh.eam.service

import java.util

import com.hxqh.eam.common.util.GroupListUtil
import com.hxqh.eam.dao.TbIocSlaPerformanceDao
import com.hxqh.eam.model.TbIocSlaPerformance
import com.hxqh.eam.model.dto._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by Ocean lin on 2017/8/2.
  */
@Service("sLAService") class SLAServiceImpl extends SLAService {

  @Autowired private val tbIocSlaPerformanceDao: TbIocSlaPerformanceDao = null

  override def variousunitData: VariousunitDto = {
    val performanceList = tbIocSlaPerformanceDao.findAll
    val stringListMap = GroupListUtil.group(performanceList, new GroupListUtil.GroupBy[String]() {
      override def groupby(obj: Any): String = {
        val d = obj.asInstanceOf[TbIocSlaPerformance]
        d.getCtype // 分组依据为Ctype

      }
    })

    val finalMap = new util.HashMap[String, IocSlaPerformanceDto]

    //遍历Map取出数据
    import scala.collection.JavaConversions._
    for (map <- stringListMap.entrySet) {
      val dto = new IocSlaPerformanceDto
      val pieDto = new IocSlaPieDto
      val list = new util.ArrayList[TbIocSlaPerformance]
      val l = new util.ArrayList[TbIocSlaPerformance]
      import scala.collection.JavaConversions._
      for (slaPerformance <- map.getValue) { //左上数据准备
        //t.SEGMENT_TYPE = 'DES' and t.SLA_TYPE='MAIN';
        if (slaPerformance.getSegmentType == map.getKey && slaPerformance.getSlaType == "MAIN") dto.setLefttop(slaPerformance)
        //右上数据
        //t.SLA_TYPE='MAINPIE';
        if (slaPerformance.getSlaType == "MAINPIE") list.add(slaPerformance)
        //下侧三个饼图
        //t.SLA_TYPE='SUB' and t.CUST_TYPE='DES'
        if (slaPerformance.getCustType != null && slaPerformance.getCustType == map.getKey)
          if (slaPerformance.getSlaType == "SUB")
            pieDto.setPieObj(slaPerformance)
          else if (slaPerformance.getSlaType == "SUBPIE")
            l.add(slaPerformance)

      }
      dto.setRighttopList(list)

      val pieMap = GroupListUtil.group(l, new GroupListUtil.GroupBy[String]() {
        override def groupby(obj: Any): String = {
          val d = obj.asInstanceOf[TbIocSlaPerformance]
          d.getSegmentType // 分组依据为SegmentType
        }
      })
      pieDto.setPieMap(pieMap)
      dto.setPieDto(pieDto)
      finalMap.put(map.getKey, dto)
    }
    new VariousunitDto(finalMap)
  }


  override def viewperregionData: ViewperregionDto = {
    val x = null
    x
  }

  override def perserviceData: PerserviceDto = ???

  override def internalData: InternalDto = ???
}






package com.hxqh.eam.service

import com.hxqh.eam.dao.TbIocSlaPerformanceDao
import com.hxqh.eam.model.dto.{InternalDto, PerserviceDto, VariousunitDto, ViewperregionDto}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by Ocean lin on 2017/8/2.
  */
@Service("sLAService") class SLAServiceImpl extends SLAService {

  @Autowired private val tbIocSlaPerformanceDao: TbIocSlaPerformanceDao = null

  override def variousunitData: VariousunitDto = {
    val x: VariousunitDto = null
    x
  }

  override def viewperregionData: ViewperregionDto = {
    val x: ViewperregionDto = null
    x
  }

  override def perserviceData: PerserviceDto = ???

  override def internalData: InternalDto = ???
}






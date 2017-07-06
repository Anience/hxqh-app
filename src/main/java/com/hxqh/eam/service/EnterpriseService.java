
package com.hxqh.eam.service;


import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.GovernmentDto;

/**
 * Created by lh on 2017-6-27 .
 */
public interface EnterpriseService {

    BussinessDto getbussinessData();

    GovernmentDto getgovernmentData();

    EnterpriseDto getenterpriseData();
}

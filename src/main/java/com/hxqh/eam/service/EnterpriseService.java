
package com.hxqh.eam.service;


import com.hxqh.eam.model.dto.EnterpriseTopDto;

/**
 * Created by lh on 2017-6-27 .
 */
public interface EnterpriseService {


    EnterpriseTopDto getTopData(Integer show,String type);
}

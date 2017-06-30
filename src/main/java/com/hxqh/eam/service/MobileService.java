package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.Mob88Dto;
import com.hxqh.eam.model.dto.Mob91Dto;
import com.hxqh.eam.model.view.VMob86;
import com.hxqh.eam.model.view.VMob87;
import com.hxqh.eam.model.view.VMob87Class;
import com.hxqh.eam.model.view.VMob92;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface MobileService {

    Mob91Dto vMob91Data();

    List<VMob92> vMob92Data();

    List<VMob87Class> vMob87ClassData();

    List<VMob86> vMob86Data();

    List<VMob87> vMob87Data();

    Mob88Dto getMob88Data();
}

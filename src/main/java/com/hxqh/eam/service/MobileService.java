package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.Mob88Dto;
import com.hxqh.eam.model.dto.Mob91Dto;
import com.hxqh.eam.model.view.*;

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

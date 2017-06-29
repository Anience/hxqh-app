package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.MapDto;
import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.model.view.VAno82;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface AnoService {


    List<VAno81> getAno81Data();

    List<VAno82> getAno82Data();

    MapDto getMapData();
}

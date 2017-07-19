package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.IndiHomeDto;
import com.hxqh.eam.model.dto.OpenMapLinesDto;
import com.hxqh.eam.model.dto.OpenMapTableDto;
import com.hxqh.eam.model.dto.VoiceDto;
import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.model.view.VAno82;
import com.hxqh.eam.model.view.VMapOpenmappoint;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface AnoService {

    List<VAno81> getAno81Data();

    List<VAno82> getAno82Data();

    IndiHomeDto getIndiHomeData();

    List<VMapOpenmappoint> getOpenMapPointsList();

    OpenMapLinesDto getOpenMapLinesData();

    OpenMapTableDto getOpenMapTableData();

    VoiceDto getVoiceTrafficData();

    List<VMapOpenmappoint> mapPointsList(String mtype, String treg);
}

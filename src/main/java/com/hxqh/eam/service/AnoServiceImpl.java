package com.hxqh.eam.service;

import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.MapDto;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Service("anoService")
public class AnoServiceImpl implements AnoService {

    @Autowired
    private VAno81Dao vAno81Dao;
    @Autowired
    private VAno82Dao ano82Dao;
    @Autowired
    private VMapMaplineDao mapMaplineDao;
    @Autowired
    private VMapNeighbourDao mapNeighbourDao;
    @Autowired
    private VMapStreetmapDao mapStreetmapDao;


    @Override
    public List<VAno81> getAno81Data() {
        return vAno81Dao.findAll();
    }

    @Override
    public List<VAno82> getAno82Data() {
        return ano82Dao.findAll();
    }

    @Override
    public MapDto getMapData() {
        List<VMapMapline> mapMapline = mapMaplineDao.findAll();
        List<VMapNeighbour> mapNeighbour = mapNeighbourDao.findAll();
        List<VMapStreetmap> mapStreetmap = mapStreetmapDao.findAll();
        MapDto mapDto = new MapDto(mapMapline,mapNeighbour,mapStreetmap);
        return mapDto;
    }
}

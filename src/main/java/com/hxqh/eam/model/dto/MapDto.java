package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMapMapline;
import com.hxqh.eam.model.view.VMapNeighbour;
import com.hxqh.eam.model.view.VMapStreetmap;

import java.util.List;

/**
 * Created by Ocean lin on 2017/6/29.
 */
public class MapDto {
    private  List<VMapMapline>  mapMaplineList;

    private List<VMapNeighbour> mapNeighbourList;

    private  List<VMapStreetmap>  mapStreetmapList;

    public MapDto(List<VMapMapline> mapMaplineList, List<VMapNeighbour> mapNeighbourList, List<VMapStreetmap> mapStreetmapList) {
        this.mapMaplineList = mapMaplineList;
        this.mapNeighbourList = mapNeighbourList;
        this.mapStreetmapList = mapStreetmapList;
    }

    public List<VMapMapline> getMapMaplineList() {
        return mapMaplineList;
    }

    public void setMapMaplineList(List<VMapMapline> mapMaplineList) {
        this.mapMaplineList = mapMaplineList;
    }

    public List<VMapNeighbour> getMapNeighbourList() {
        return mapNeighbourList;
    }

    public void setMapNeighbourList(List<VMapNeighbour> mapNeighbourList) {
        this.mapNeighbourList = mapNeighbourList;
    }

    public List<VMapStreetmap> getMapStreetmapList() {
        return mapStreetmapList;
    }

    public void setMapStreetmapList(List<VMapStreetmap> mapStreetmapList) {
        this.mapStreetmapList = mapStreetmapList;
    }
}

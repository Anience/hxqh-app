package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.dto.IndiHomeDto;
import com.hxqh.eam.model.dto.OpenMapLinesDto;
import com.hxqh.eam.model.dto.OpenMapTableDto;
import com.hxqh.eam.model.dto.VoiceDto;
import com.hxqh.eam.model.view.VAno81;
import com.hxqh.eam.model.view.VAno82;
import com.hxqh.eam.model.view.VMapOpenmappoint;
import com.hxqh.eam.service.AnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ano")
@SessionAttributes(value = "sessionInfo")
public class AnoController {

    @Autowired
    private AnoService anoService;

    /**
     * 1. AWAS 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/ano81", method = RequestMethod.GET)
    public String ano81() {
        return "ano/ano81";
    }


    /**
     * 1. AWAS 数据接口
     * Access 2017-6-26 09:40:21
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ano81Data", method = RequestMethod.GET)
    public List<VAno81> ano81Data() {
        List<VAno81> ano81Data = anoService.getAno81Data();
        return ano81Data;
    }


    /**
     * 2. Gamas 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/ano82", method = RequestMethod.GET)
    public String ano82() {
        return "ano/ano82";
    }

    /**
     * 2. Gamas 数据接口
     * Access 2017-6-26 09:40:29
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ano82Data", method = RequestMethod.GET)
    public List<VAno82> ano82Data() {
        List<VAno82> ano82Data = anoService.getAno82Data();
        return ano82Data;
    }


    /**
     * map 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map() {
        return "centerMap/map";
    }

    /**
     * mapPoint 数据接口
     * mtype：TERA PE METRO TOTAL
     * treg： 1 2 3 4 5 6 7 8
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mapPoint", method = RequestMethod.GET)
    public List<VMapOpenmappoint> mapPoint(@RequestParam("mtype") String mtype,
                                           @RequestParam("treg") String treg) {
        List<VMapOpenmappoint> openmappointList = anoService.mapPointsList(mtype,treg);
        return openmappointList;
    }


    /**
     * openMapPoints 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/openMapPoints", method = RequestMethod.GET)
    public List<VMapOpenmappoint> openMapPoints() {
        List<VMapOpenmappoint> openmappointList = anoService.getOpenMapPointsList();
        return openmappointList;
    }


    /**
     * openMapLines 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/openMapLines", method = RequestMethod.GET)
    public OpenMapLinesDto openMapLines() {
        OpenMapLinesDto mapLinesDto = anoService.getOpenMapLinesData();
        return mapLinesDto;
    }


    /**
     * 查询红色报警点 数据接口
     *
     * @return
     */
    @ResponseBody
        @RequestMapping(value = "/redPoint", method = RequestMethod.GET)
    public List<VMapOpenmappoint> redPoint() {
        List<VMapOpenmappoint> redPoint = anoService.getRedPoint();
        return redPoint;
    }

    /**
     * openMapTable 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/openMapTable", method = RequestMethod.GET)
    public OpenMapTableDto openMapTable() {
        OpenMapTableDto mapTableDto = anoService.getOpenMapTableData();
        return mapTableDto;
    }


    /**
     * indiHome 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/indiHome", method = RequestMethod.GET)
    public String indiHome() {
        return "consumer/ind";
    }


    /**
     * indiHome 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/indiHomeData", method = RequestMethod.GET)
    public IndiHomeDto indiHomeData() {
        IndiHomeDto indiHomeDto = anoService.getIndiHomeData();
        return indiHomeDto;
    }

    /**
     * voice traffic performance 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/voice", method = RequestMethod.GET)
    public String voicetraffic() {
        return "consumer/voicetraffic";
    }


    /**
     *  voice traffic performance  数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/voiceData", method = RequestMethod.GET)
    public VoiceDto getVoiceTrafficData() {
        VoiceDto voiceDto = anoService.getVoiceTrafficData();
        return voiceDto;
    }


}

package com.hxqh.eam.service;

import com.hxqh.eam.dao.VDig13Dao;
import com.hxqh.eam.dao.VDig14Dao;
import com.hxqh.eam.dao.VDig17Dao;
import com.hxqh.eam.dao.VDig18Dao;
import com.hxqh.eam.model.view.VDig13;
import com.hxqh.eam.model.view.VDig14;
import com.hxqh.eam.model.view.VDig17;
import com.hxqh.eam.model.view.VDig18;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Service("digitalService")
public class DigitalServiceImpl implements DigitalService {
    @Autowired
    private VDig13Dao vDig13Dao;
    @Autowired
    private VDig14Dao vDig14Dao;
    @Autowired
    private VDig17Dao vDig17Dao;
    @Autowired
    private VDig18Dao vDig18Dao;

    @Override
    public List<VDig13> digital13Data() {
        return vDig13Dao.findAll();
    }

    @Override
    public List<VDig14> vDig14Data() {
        return vDig14Dao.findAll();
    }

    @Override
    public List<VDig17> vDig17Data() {
        return vDig17Dao.findAll();
    }

    @Override
    public List<VDig18> vDig18Data() {
        return vDig18Dao.findAll();
    }

    //TODO  暂时未处理
    @Override
    public List<VDig18> vDig13141718Data() {
        return null;
    }
}

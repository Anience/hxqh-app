package com.hxqh.eam.service;

import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
@Service("mobileService")
public class MobileServiceImpl implements MobileService {


    @Autowired
    private VMob86Dao vMob86Dao;
    @Autowired
    private VMob87ClassDao vMob87ClassDao;
    @Autowired
    private VMob87Dao vMob87Dao;
    @Autowired
    private VMob88Dao vMob88Dao;
    @Autowired
    private VMob91Dao vMob91Dao;
    @Autowired
    private VMob92Dao vMob92Dao;

    @Override
    public List<VMob91> vMob91Data() {
        return vMob91Dao.findAll();
    }

    @Override
    public List<VMob92> vMob92Data() {
        return vMob92Dao.findAll();
    }

    @Override
    public List<VMob88> vMob88Data() {
        return vMob88Dao.findAll();
    }

    @Override
    public List<VMob87Class> vMob87ClassData() {
        return vMob87ClassDao.findAll();
    }

    @Override
    public List<VMob86> vMob86Data() {
        return vMob86Dao.findAll();
    }

    @Override
    public List<VMob87> vMob87Data() {
        return vMob87Dao.findAll();
    }
}

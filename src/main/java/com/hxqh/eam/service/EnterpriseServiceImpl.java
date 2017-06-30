package com.hxqh.eam.service;


import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.BussinessDto;
import com.hxqh.eam.model.dto.EnterpriseDto;
import com.hxqh.eam.model.dto.GovernmentDto;
import com.hxqh.eam.model.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by lh on 2017-6-27 .
 */
@Transactional
@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private VEntBusBottomOneDao entBusBottomOneDao;
    @Autowired
    private VEntBusBottomThreeDao entBusBottomThreeDao;
    @Autowired
    private VEntBusBottomTwoDao entBusBottomTwoDao;
    @Autowired
    private VEntBusTopOneDao entBusTopOneDao;
    @Autowired
    private VEntBusTopThreeDao entBusTopThreeDao;
    @Autowired
    private VEntBusTopTwoDao entBusTopTwoDao;
    @Autowired
    private VEntEntBottomOneDao entEntBottomOneDao;
    @Autowired
    private VEntEntBottomThreeDao entEntBottomThreeDao;
    @Autowired
    private VEntEntBottomTwoDao entEntBottomTwoDao;
    @Autowired
    private VEntEntTopOneDao entEntTopOneDao;
    @Autowired
    private VEntEntTopThreeDao entEntTopThreeDao;
    @Autowired
    private VEntEntTopTwoDao entEntTopTwoDao;
    @Autowired
    private VEntGovTopOneDao entGovTopOneDao;
    @Autowired
    private VEntGovTopTwoDao entGovTopTwoDao;
    @Autowired
    private VEntGovTopThreeDao entGovTopThreeDao;
    @Autowired
    private VEntGovBottomOneDao entGovBottomOneDao;
    @Autowired
    private VEntGovBottomTwoDao entGovBottomTwoDao;
    @Autowired
    private VEntGovBottomThreeDao entGovBottomThreeDao;


    @Override
    public BussinessDto getbussinessData() {
        List<VEntBusTopOne> entBusTopOnes = entBusTopOneDao.findAll();
        List<VEntBusTopTwo> entBusTopTwos = entBusTopTwoDao.findAll();
        List<VEntBusTopThree> busTopThrees = entBusTopThreeDao.findAll();

        List<VEntBusBottomOne> busBottomOneList = entBusBottomOneDao.findAll();
        List<VEntBusBottomTwo> busBottomTwoList = entBusBottomTwoDao.findAll();
        List<VEntBusBottomThree> busBottomThreeList = entBusBottomThreeDao.findAll();
        BussinessDto bussinessDto = new BussinessDto(busBottomOneList, busBottomThreeList, busBottomTwoList,
                entBusTopOnes, busTopThrees, entBusTopTwos);
        return bussinessDto;
    }

    @Override
    public GovernmentDto getgovernmentData() {
        List<VEntGovTopOne> entGovTopOne = entGovTopOneDao.findAll();
        List<VEntGovTopTwo> entGovTopTwo = entGovTopTwoDao.findAll();
        List<VEntGovTopThree> entGovTopThree = entGovTopThreeDao.findAll();
        List<VEntGovBottomOne> entGovBottomOne = entGovBottomOneDao.findAll();
        List<VEntGovBottomTwo> entGovBottomTwo = entGovBottomTwoDao.findAll();
        List<VEntGovBottomThree> entGovBottomThree = entGovBottomThreeDao.findAll();
        GovernmentDto governmentDto = new GovernmentDto(entGovTopOne, entGovTopTwo, entGovTopThree, entGovBottomOne, entGovBottomTwo, entGovBottomThree);

        return governmentDto;
    }

    @Override
    public EnterpriseDto getenterpriseData() {
        List<VEntEntBottomOne> entEntBottomOne = entEntBottomOneDao.findAll();

        List<VEntEntBottomThree> entEntBottomThree = entEntBottomThreeDao.findAll();

        List<VEntEntBottomTwo> entEntBottomTwo = entEntBottomTwoDao.findAll();

        List<VEntEntTopOne> entEntTopOne = entEntTopOneDao.findAll();

        List<VEntEntTopThree> entEntTopThree = entEntTopThreeDao.findAll();

        List<VEntEntTopTwo> entEntTopTwo = entEntTopTwoDao.findAll();
        EnterpriseDto enterpriseDt = new EnterpriseDto(entEntBottomOne, entEntBottomThree, entEntBottomTwo,
                entEntTopOne, entEntTopThree, entEntTopTwo);
        return enterpriseDt;
    }
}

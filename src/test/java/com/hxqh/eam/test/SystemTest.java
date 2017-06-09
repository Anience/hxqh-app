package com.hxqh.eam.test;

import com.hxqh.eam.dao.AppDao;
import com.hxqh.eam.dao.AttributecfgDao;
import com.hxqh.eam.dao.G03unitDao;
import com.hxqh.eam.model.App;
import com.hxqh.eam.model.Attributecfg;
import com.hxqh.eam.model.G03unit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lh on 2017/5/5.
 */

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemTest {

    @Resource
    private AppDao appDao;

    @Resource
    private AttributecfgDao attributecfgDao;

    @Resource
    private G03unitDao g03unitDao;

    @Test
    public void testGetAppDate() {
        List<App> appDaoAll = appDao.findAll();
        Assert.assertTrue(appDaoAll.size()>0);

        App app = appDao.find("iaet324stt9re3c81wvovuqx89t");
        Assert.assertEquals(app.getApptype(),"app");
        Assert.assertEquals(app.getDescription(),"Cron Task");

        List<Attributecfg> attributecfgList = attributecfgDao.findAll();
        Assert.assertTrue(attributecfgList.size()>0);

        List<G03unit> g03unitList = g03unitDao.findAll();
        Assert.assertTrue(g03unitList.size()>0);

    }




}

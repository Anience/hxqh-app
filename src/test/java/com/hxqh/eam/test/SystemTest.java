package com.hxqh.eam.test;

import com.hxqh.eam.dao.AppDao;
import com.hxqh.eam.model.App;
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

    @Test
    public void testGetAppDate() {
        List<App> appDaoAll = appDao.findAll();
        Assert.assertTrue(appDaoAll.size()>0);

        App app = appDao.find("iaet324stt9re3c81wvovuqx89t");
        Assert.assertEquals(app.getApptype(),"app");
        Assert.assertEquals(app.getDescription(),"Cron Task");
    }




}

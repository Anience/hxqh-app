package com.hxqh.eam.test;

import com.hxqh.eam.dao.SfOrganizationAccountDao;
import com.hxqh.eam.dao.VAno81Dao;
import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.view.VAno81;
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
public class ViewTest {

    @Resource
    private VAno81Dao vAno81Dao;

    @Resource
    private SfOrganizationAccountDao organizationAccountDao;

    @Test
    public void testGetViewData() {
        List<VAno81> all = vAno81Dao.findAll();
        Assert.assertTrue(all.size() > 0);
        List<SfOrganizationAccount> organizationAccountList = organizationAccountDao.findAll();
        Assert.assertTrue(organizationAccountList.size() > 0);

    }

}

package com.hxqh.eam.service;

import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.AccountDto;
import com.hxqh.eam.model.dto.RoleDto;
import com.hxqh.eam.model.dto.TestDto;
import com.hxqh.eam.model.dto.action.LoginDto;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    static Logger logger = Logger.getLogger(SystemServiceImpl.class);

    @Autowired
    private SfOrganizationAccountDao organizationAccountDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SfOrganizationDepartmentDao sfOrganizationDepartmentDao;
    @Autowired
    private TbIocCustTop7Dao tbIocCustTop7Dao;
    @Autowired
    private TbIoccustomeruserDao ioccustomeruserDao;
    @Resource
    protected SessionFactory sessionFactory;

//    @Autowired
//    private TbIocSlaPerformanceDao iocSlaPerformanceDao;

    @Override
    public List<SfOrganizationAccount> getLoginUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", loginDto.getName());
        String where = "name=:name ";
        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public List<Menu> getMenuListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        //        params.put("name", "");
        //        String where = "name=:name ";
        //        List<Menu> menuList = menuDao.findAll(where, params, null);
        List<Menu> menuList = menuDao.findAll();
        return menuList;
    }

    @Override
    public void editMenu(Menu menu) throws Exception {
        menuDao.update(menu);
    }

    @Override
    public void addMenu(Menu menu) throws Exception {
        menuDao.save(menu);
    }

    @Override
    public void delMenu(String menuid) throws Exception {
        menuDao.delete(menuid);
    }

    @Override
    public AccountDto getUserListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));

        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll();
        long allUser = organizationAccountDao.getCount();
        long normal = organizationAccountDao.getCount();
        long onlineUser = organizationAccountDao.getCount("login=:login", params);

        AccountDto accountDto = new AccountDto(accountList, allUser, normal, onlineUser);
        return accountDto;
    }

    @Override
    public RoleDto getRoleListData() {
        return null;
    }

    @Override
    public List<TbIocCustTop7> custtop7ListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("custtype", "DWS");
        String where = "custtype<>:custtype";
        return tbIocCustTop7Dao.findAll(where, params, null);
    }

    @Override
    public List<TbIoccustomeruser> customeruserListData(String name, String div) {
        Map<String, Object> params = new HashMap<>();
        params.put("div", div);
        List<TbIoccustomeruser> ioccustomeruserList = new ArrayList<>();
        if ("no".equals(name)) {
            String where = "div=:div";
            ioccustomeruserList = ioccustomeruserDao.findAll(where, params, null);
        } else {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ").append(" and div=:div ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        }
        return ioccustomeruserList;
    }

    @Transactional
    @Override
    public void updateRank(Long ioccustomeruserid, String custid, String name) {
        TbIocCustTop7 iocCustTop7 = tbIocCustTop7Dao.find(custid);
        TbIoccustomeruser ioccustomeruser = ioccustomeruserDao.find(ioccustomeruserid);

        iocCustTop7.setCustid(String.valueOf(ioccustomeruser.getIoccustomeruserid()));
        iocCustTop7.setCustname(ioccustomeruser.getCustName());
        iocCustTop7.setName(name);

        tbIocCustTop7Dao.update(iocCustTop7);
        //TODO call procedure

    }


    @Transactional
    @Override
    public void callProcedure() {
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
    }

    @Override
    public TestDto testData() {
        return new TestDto();
    }

    @Override
    public TbIocCustTop7 getrankDetail(String ioccustomerusertop7id) {
        return tbIocCustTop7Dao.find(ioccustomerusertop7id);
    }

    @Override
    public void editUser(SfOrganizationAccount account) {
        organizationAccountDao.update(account);
    }

    @Override
    public void addUser(SfOrganizationAccount account) {
        organizationAccountDao.save(account);
    }

    @Override
    public void delUser(String id) {
        organizationAccountDao.delete(id);
    }


    @Override
    public List<SfOrganizationAccount> findOnlineUserList() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));
        String where = "login=:login ";
        List<SfOrganizationAccount> organizationAccountList = organizationAccountDao.findAll(where, params, null);
        return organizationAccountList;
    }

    @Override
    public List<SfOrganizationDepartment> getDepartmentList() {
        return sfOrganizationDepartmentDao.findAll();
    }




}

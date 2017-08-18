package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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
    @Autowired
    private TbModelDao modelDao;
    @Autowired
    private TbRoleDao roleDao;
    @Autowired
    private TbRolemodelDao rolemodelDao;
    @Autowired
    private TbUserroleDao userroleDao;

    @Resource
    protected SessionFactory sessionFactory;


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
    public UserDto getUserListData() {
        String sql = "select t1.id,t1.name,t3.rolename from sf_organization_account t1\n" +
                "  left join tb_userrole t2\n" +
                "    on t1.id = t2.id\n" +
                "  left join tb_role t3 \n" +
                "  on t2.roleid = t3.roleid";
        List<UserRoleDto> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(UserRoleDto.class).list();
        return new UserDto(list);
    }

    @Override
    public RoleDto getRoleListData() {
        List<TbRole> roleList = roleDao.findAll();
        return new RoleDto(roleList);
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

        List<TbIoccustomeruser> ioccustomeruserList = new ArrayList<>();
        if (name.equals("") && div.equals("")) {
            ioccustomeruserList = ioccustomeruserDao.findAll();
        } else if (name.equals("")) {
            params.put("div", div);
            String where = "div=:div";
            ioccustomeruserList = ioccustomeruserDao.findAll(where, params, null);
        } else if (div.equals("")) {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        } else {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ").append(" or div=:div ");
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
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
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
    public void userRole(String id, BigDecimal roleid) {
        TbUserrole userrole = new TbUserrole(id, roleid);
        userroleDao.save(userrole);
    }

    @Override
    public SfOrganizationAccount findUserbyId(String id) {
        return organizationAccountDao.find(id);
    }

    @Override
    public ModelDto getModelListData() {
        //分别返回一级节点和二级节点
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("sortnum", "asc");
        List<TbModel> modelList = modelDao.findAll(null,null,orderby);
        //对modelList分组
        Map<Integer, List<TbModel>> listMap = GroupListUtil.group(modelList, new GroupListUtil.GroupBy<Integer>() {
            @Override
            public Integer groupby(Object obj) {
                TbModel d = (TbModel) obj;
                return d.getIsmdeol();    // 分组依据为mdeol
            }
        });

        return new ModelDto(listMap);
    }

    @Override
    public void editrole(TbRole account) {
        roleDao.update(account);
    }

    @Override
    public void addrole(TbRole account) {
        roleDao.save(account);
    }

    @Override
    public void delrole(String id) {
        roleDao.delete(id);
    }

    @Override
    public void editmodel(TbModel account) {
        modelDao.update(account);
    }

    @Override
    public void addmodel(TbModel account) {
        modelDao.save(account);
    }

    @Override
    public void delmodel(String id) {
        modelDao.delete(id);
    }

    @Override
    public void roleModel(String models, BigDecimal roleid) {
        String[] split = models.split(",");
        for (int i = 0; i < split.length; i++) {
            BigDecimal bd = new BigDecimal(split[i]);
            TbRolemodel rolemodel = new TbRolemodel(bd, roleid);
            rolemodelDao.save(rolemodel);
        }
    }

    @Override
    public ModelRoleDto getModelRoleData() {
        //TODO 根据role确定已经授权和未授权的模块

        return null;
    }

    @Override
    public List<TbRole> findRoleList() {
       return roleDao.findAll();
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

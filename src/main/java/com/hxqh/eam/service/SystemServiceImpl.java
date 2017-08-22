package com.hxqh.eam.service;

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.common.util.MailUtils;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${hxqh.email.name}")
    private String serverName;
    @Value("${hxqh.email.username}")
    private String username;
    @Value("${hxqh.email.password}")
    private String password;
    @Value("${hxqh.email.path.name}")
    private String pathName;

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
    @Autowired
    private UserDao userDao;
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
        String sql = "select distinct (t1.userid) as id, t1.loginname as name, t3.rolename\n" +
                "  from TB_USER t1\n" +
                "  left join tb_userrole t2\n" +
                "    on t1.userid = t2.userid\n" +
                "  left join tb_role t3\n" +
                "    on t2.roleid = t3.roleid";
        List<UserRoleDto> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(UserRoleDto.class).list();
        return new UserDto(list);
    }

    @Override
    public List<TbRole> getRoleListData() {
        return roleDao.findAll();
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

//        TbUserrole userrole = new TbUserrole(id, roleid);
//        userroleDao.save(userrole);
    }

    @Override
    public UserObj findUserbyId(Long id) {
        return userDao.find(id);
    }

    @Override
    public ModelDto getModelListData() {
        //分别返回一级节点和二级节点
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("sortnum", "asc");
        List<TbModel> modelList = modelDao.findAll(null, null, orderby);
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
    public void roleModel(String models, Long roleid) {
        TbRole role = roleDao.find(roleid);
        String[] split = models.split(",");
        List<TbModel> modelList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            modelList.add(modelDao.find(Long.valueOf(split[i])));
        }

        for (TbModel e : modelList) {
            TbRolemodel rolemodel = new TbRolemodel(e, role);
            rolemodelDao.save(rolemodel);
        }
    }

    @Override
    public ModelRoleDto getModelRoleData(Long roleid) {
        TbRole role = roleDao.find(roleid);
        List<TbModel> modelHaveList = new ArrayList<>();
        for (TbRolemodel rolemodel : role.getTbRolemodels()) {
            modelHaveList.add(modelDao.find(rolemodel.getTbModel().getModelid()));
        }
        Map<String, Object> params = new HashMap<>();
        params.put("ismdeol", 1);
        String where = "ismdeol=:ismdeol ";

        List<TbModel> modelNoList = modelDao.findAll(where, params, null);
        modelNoList.removeAll(modelHaveList);

        return new ModelRoleDto(modelNoList, modelHaveList);
    }

    @Override
    public List<TbRole> findRoleList() {
        return roleDao.findAll();
    }

    @Override
    public List<UserObj> getUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginDto.getName());
        String where = "loginname=:loginname ";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public int forgetPassword(String loginname, String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            accountList.get(0).setUserstatus(0);
            return 1;
        }
        return 0;
    }

    @Override
    public int resetPassword(Long userid) {
        UserObj userObj = userDao.find(userid);
        //重置密码 初始密码123456
        String password = Account.encrypt("123456");
        userObj.setLoginpassword(password);
        userDao.save(userObj);
        //发送邮件
        if (userObj.getLoginname() != null && userObj.getEmail() != null) {
            sendEmail(userObj.getLoginname(), userObj.getEmail());
        }
        return 0;
    }

    @Override
    public int sendEmail(String loginname, String email) {
        MailUtils cn = new MailUtils();

        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            // 设置发件人地址、收件人地址和邮件标题
            cn.setAddress(username, accountList.get(0).getEmail(), "The password has been reset");
            // 设置要发送附件的位置和标题
            cn.setAffix(pathName, "attach.txt");

            /**
             * 设置smtp服务器以及邮箱的帐号和密码
             * 用QQ 邮箱作为发生者不好使 （原因不明）
             * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
             * 因为程序属于第三方登录，所以登录密码必须使用163的授权码
             */
            // 注意： [授权码和你平时登录的密码是不一样的]
            cn.send(serverName, username, password, "重置密码为123456");
            return 1;
        }
        return 0;
    }


    @Override
    public TbIocCustTop7 getrankDetail(String ioccustomerusertop7id) {
        return tbIocCustTop7Dao.find(ioccustomerusertop7id);
    }

    @Override
    public void editUser(UserObj account) {
        userDao.update(account);
    }

    @Override
    public void addUser(UserObj account, Long roleid) {
        // 写TB_USER表
        //设置密码 初始密码123456
        String password = Account.encrypt("123456");
        account.setLoginpassword(password);
        account.setUserstatus(1);

        userDao.save(account);
        // 写TB_USERROLE表
        TbUserrole urobj = new TbUserrole();
        urobj.setTbRole(roleDao.find(new BigDecimal(roleid)));
        urobj.setTbUser(account);
        userroleDao.save(urobj);
    }

    @Override
    public void delUser(Long id) {
        if (!(id == 1)) {
            userDao.delete(id);
        }
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

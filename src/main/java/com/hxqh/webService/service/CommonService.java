package com.hxqh.webService.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * ╔          ╗
 * § File Name:  CommonService.java                             §
 * §┇File Path: com.hxqh.webService.service.CommonService           §
 * §Descrption:  公用服务接口                                        §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚                  ╝
 */
@WebService
public interface CommonService {

    /**
     * 获取用户列表
     *
     * @return
     */
    @WebMethod
    String getUserList();

    /**
     * 获取角色列表
     *
     * @return
     */
    @WebMethod
    String getRoleList();

    /**
     * 获取资源列表
     *
     * @return
     */
    @WebMethod
    String getResouleList();

    /**
     * 操作用户（新增、修改、修改密码）
     *
     * @param inPutVal
     * @return
     */
    @WebMethod
    String OptionUser(@WebParam(name = "inPutVal") String inPutVal, @WebParam(name = "optionType") int optionType);

    /**
     * 角色操作
     *(新增、删除、修改)
     * @param inPutVal
     * @return
     */
    @WebMethod
    String OptionRole(@WebParam(name = "inPutVal") String inPutVal, @WebParam(name = "optionType") int optionType);

    /**
     * 操作角色拥有的资源以及关联的用户
     * @param inPutVal
     * @param optionType
     * @return
     */
    @WebMethod
    String OptionRoleSource(@WebParam(name = "inPutVal") String inPutVal, @WebParam(name = "optionType") int optionType);




}

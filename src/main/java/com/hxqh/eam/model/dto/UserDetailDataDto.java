package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.TbRole;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/16.
 */
public class UserDetailDataDto {

    private SfOrganizationAccount account;
    private List<TbRole> roleList;

    public UserDetailDataDto() {
    }

    public UserDetailDataDto(SfOrganizationAccount account, List<TbRole> roleList) {
        this.account = account;
        this.roleList = roleList;
    }

    public SfOrganizationAccount getAccount() {
        return account;
    }

    public void setAccount(SfOrganizationAccount account) {
        this.account = account;
    }

    public List<TbRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TbRole> roleList) {
        this.roleList = roleList;
    }
}

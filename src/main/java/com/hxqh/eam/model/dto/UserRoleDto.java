package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/8/11.
 */
@Entity
public class UserRoleDto {

    @Id
    private String id;
    private String name;
    private String rolename;

    public UserRoleDto() {
    }

    public UserRoleDto(String id, String name, String rolename) {
        this.id = id;
        this.name = name;
        this.rolename = rolename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}

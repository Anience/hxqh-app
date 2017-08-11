package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_ROLEMODEL database table.
 */
@Entity
@Table(name = "TB_ROLEMODEL")
public class TbRolemodel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_ROLEMODEL_ROLEMODELID_GENERATOR", allocationSize = 1,sequenceName = "SEQ_ROLEMODEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ROLEMODEL_ROLEMODELID_GENERATOR")
    private long rolemodelid;

    private BigDecimal modelid;

    private BigDecimal roleid;

    public TbRolemodel() {
    }

    public TbRolemodel(BigDecimal modelid, BigDecimal roleid) {
        this.modelid = modelid;
        this.roleid = roleid;
    }

    public long getRolemodelid() {
        return this.rolemodelid;
    }

    public void setRolemodelid(long rolemodelid) {
        this.rolemodelid = rolemodelid;
    }

    public BigDecimal getModelid() {
        return this.modelid;
    }

    public void setModelid(BigDecimal modelid) {
        this.modelid = modelid;
    }

    public BigDecimal getRoleid() {
        return this.roleid;
    }

    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }

}
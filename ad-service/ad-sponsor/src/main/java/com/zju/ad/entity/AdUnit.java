package com.zju.ad.entity;

import java.util.Date;

public class AdUnit {
    private Long id;

    private Long planId;

    private String unitName;

    private Byte unitStatus;

    private Byte positionType;

    private Long budget;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Byte getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(Byte unitStatus) {
        this.unitStatus = unitStatus;
    }

    public Byte getPositionType() {
        return positionType;
    }

    public void setPositionType(Byte positionType) {
        this.positionType = positionType;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
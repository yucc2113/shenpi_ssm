package com.ccgj.database.beans;

import java.util.Date;

public class FlowStep {
    private Integer id;

    private Integer flowId;

    private Byte stepNo;

    private String stepName;

    private String dealUser;

    private Integer dealRole;

    private String dealPosition;

    private Integer lastId;

    private Integer nextId;

    private Integer stepType;

    private Date addTime;

    private Date updateTime;

    private String libusername;

    private Integer flag;

    private String leixing;

    private String conditions;

    private String conditionmsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Byte getStepNo() {
        return stepNo;
    }

    public void setStepNo(Byte stepNo) {
        this.stepNo = stepNo;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser == null ? null : dealUser.trim();
    }

    public Integer getDealRole() {
        return dealRole;
    }

    public void setDealRole(Integer dealRole) {
        this.dealRole = dealRole;
    }

    public String getDealPosition() {
        return dealPosition;
    }

    public void setDealPosition(String dealPosition) {
        this.dealPosition = dealPosition == null ? null : dealPosition.trim();
    }

    public Integer getLastId() {
        return lastId;
    }

    public void setLastId(Integer lastId) {
        this.lastId = lastId;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public Integer getStepType() {
        return stepType;
    }

    public void setStepType(Integer stepType) {
        this.stepType = stepType;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLibusername() {
        return libusername;
    }

    public void setLibusername(String libusername) {
        this.libusername = libusername == null ? null : libusername.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public String getConditionmsg() {
        return conditionmsg;
    }

    public void setConditionmsg(String conditionmsg) {
        this.conditionmsg = conditionmsg == null ? null : conditionmsg.trim();
    }
}
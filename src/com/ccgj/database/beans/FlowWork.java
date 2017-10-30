package com.ccgj.database.beans;

import java.util.Date;

public class FlowWork {
    private Integer id;

    private Integer flowId;

    private Integer stepId;

    private Byte stepNo;

    private Integer workId;

    private Integer dealUser;

    private String dealIdea;

    private Date dealDate;

    private Date addTime;

    private Byte status;

    private String dealName;

    private Integer shenpileixing;

    private Integer dealRole;

    private Integer dealPosition;

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

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Byte getStepNo() {
        return stepNo;
    }

    public void setStepNo(Byte stepNo) {
        this.stepNo = stepNo;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getDealUser() {
        return dealUser;
    }

    public void setDealUser(Integer dealUser) {
        this.dealUser = dealUser;
    }

    public String getDealIdea() {
        return dealIdea;
    }

    public void setDealIdea(String dealIdea) {
        this.dealIdea = dealIdea == null ? null : dealIdea.trim();
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName == null ? null : dealName.trim();
    }

    public Integer getShenpileixing() {
        return shenpileixing;
    }

    public void setShenpileixing(Integer shenpileixing) {
        this.shenpileixing = shenpileixing;
    }

    public Integer getDealRole() {
        return dealRole;
    }

    public void setDealRole(Integer dealRole) {
        this.dealRole = dealRole;
    }

    public Integer getDealPosition() {
        return dealPosition;
    }

    public void setDealPosition(Integer dealPosition) {
        this.dealPosition = dealPosition;
    }
}
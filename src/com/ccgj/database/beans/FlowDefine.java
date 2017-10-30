package com.ccgj.database.beans;

public class FlowDefine {
    private Integer id;

    private String flowName;

    private String flowDesc;

    private Integer isEnabled;

    private String deptids;

    private String deptname;

    private Integer biaodanId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getFlowDesc() {
        return flowDesc;
    }

    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc == null ? null : flowDesc.trim();
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getDeptids() {
        return deptids;
    }

    public void setDeptids(String deptids) {
        this.deptids = deptids == null ? null : deptids.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getBiaodanId() {
        return biaodanId;
    }

    public void setBiaodanId(Integer biaodanId) {
        this.biaodanId = biaodanId;
    }
}
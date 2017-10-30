package com.ccgj.database.beans;

import java.util.Date;

public class UdingyiBiaodan {
    private Integer id;

    private String mingchen;

    private Integer state;

    private Integer createuser;

    private String createname;

    private Date createdate;

    private Integer flowid;

    private String dcontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMingchen() {
        return mingchen;
    }

    public void setMingchen(String mingchen) {
        this.mingchen = mingchen == null ? null : mingchen.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getFlowid() {
        return flowid;
    }

    public void setFlowid(Integer flowid) {
        this.flowid = flowid;
    }

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent == null ? null : dcontent.trim();
    }
}
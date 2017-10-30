package com.ccgj.database.beans;

public class LiuchengDetail {
    private Integer id;

    private Integer shenpiid;

    private Integer baiodanid;

    private String mingchen;

    private Integer leixing;

    private String neirongValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShenpiid() {
        return shenpiid;
    }

    public void setShenpiid(Integer shenpiid) {
        this.shenpiid = shenpiid;
    }

    public Integer getBaiodanid() {
        return baiodanid;
    }

    public void setBaiodanid(Integer baiodanid) {
        this.baiodanid = baiodanid;
    }

    public String getMingchen() {
        return mingchen;
    }

    public void setMingchen(String mingchen) {
        this.mingchen = mingchen == null ? null : mingchen.trim();
    }

    public Integer getLeixing() {
        return leixing;
    }

    public void setLeixing(Integer leixing) {
        this.leixing = leixing;
    }

    public String getNeirongValue() {
        return neirongValue;
    }

    public void setNeirongValue(String neirongValue) {
        this.neirongValue = neirongValue == null ? null : neirongValue.trim();
    }
}
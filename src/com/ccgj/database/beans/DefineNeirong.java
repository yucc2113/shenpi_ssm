package com.ccgj.database.beans;

public class DefineNeirong {
    private Integer id;

    private Integer baiodanid;

    private String mingcheng;

    private Integer leidanleixing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaiodanid() {
        return baiodanid;
    }

    public void setBaiodanid(Integer baiodanid) {
        this.baiodanid = baiodanid;
    }

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? null : mingcheng.trim();
    }

    public Integer getLeidanleixing() {
        return leidanleixing;
    }

    public void setLeidanleixing(Integer leidanleixing) {
        this.leidanleixing = leidanleixing;
    }
}
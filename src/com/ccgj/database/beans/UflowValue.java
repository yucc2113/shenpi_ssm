package com.ccgj.database.beans;

public class UflowValue {
    private Integer id;

    private Integer baiodanid;

    private String dataelement;

    private String dataelementtype;

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

    public String getDataelement() {
        return dataelement;
    }

    public void setDataelement(String dataelement) {
        this.dataelement = dataelement == null ? null : dataelement.trim();
    }

    public String getDataelementtype() {
        return dataelementtype;
    }

    public void setDataelementtype(String dataelementtype) {
        this.dataelementtype = dataelementtype == null ? null : dataelementtype.trim();
    }
}
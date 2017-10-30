package com.ccgj.database.beans;

public class Module {
    private Integer id;

    private String name;

    private Integer parentid;

    private Integer typeid;

    private String conurl;

    private String imgeurl;

    private Integer paixu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getConurl() {
        return conurl;
    }

    public void setConurl(String conurl) {
        this.conurl = conurl == null ? null : conurl.trim();
    }

    public String getImgeurl() {
        return imgeurl;
    }

    public void setImgeurl(String imgeurl) {
        this.imgeurl = imgeurl == null ? null : imgeurl.trim();
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }
}
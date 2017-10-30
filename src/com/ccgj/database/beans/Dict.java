package com.ccgj.database.beans;

public class Dict {
    private Integer id;

    private String prop;

    private String types;

    private String memos;

    private Integer flag;

    private Integer parentid;

    private Integer leixing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop == null ? null : prop.trim();
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types == null ? null : types.trim();
    }

    public String getMemos() {
        return memos;
    }

    public void setMemos(String memos) {
        this.memos = memos == null ? null : memos.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getLeixing() {
        return leixing;
    }

    public void setLeixing(Integer leixing) {
        this.leixing = leixing;
    }
}
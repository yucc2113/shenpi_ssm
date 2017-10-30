package com.ccgj.database.beans;

import java.util.Date;

public class Systemlog {
    private Integer id;

    private String creatusername;

    private Integer creatuserid;

    private String logcontent;

    private Date creatdate;

    private String remark1;

    private Integer remark2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatusername() {
        return creatusername;
    }

    public void setCreatusername(String creatusername) {
        this.creatusername = creatusername == null ? null : creatusername.trim();
    }

    public Integer getCreatuserid() {
        return creatuserid;
    }

    public void setCreatuserid(Integer creatuserid) {
        this.creatuserid = creatuserid;
    }

    public String getLogcontent() {
        return logcontent;
    }

    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent == null ? null : logcontent.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public Integer getRemark2() {
        return remark2;
    }

    public void setRemark2(Integer remark2) {
        this.remark2 = remark2;
    }
}
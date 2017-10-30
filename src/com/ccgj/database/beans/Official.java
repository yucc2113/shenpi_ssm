package com.ccgj.database.beans;

import java.util.Date;

public class Official {
    private Integer id;

    private String filename;

    private Integer filesize;

    private String wenhao;

    private String filetype;

    private String filenamedisk;

    private String attachfilenamedisk;

    private String attachfiledescribe;

    private Integer createuser;

    private Date createdate;

    private String createname;

    private Integer approveuser;

    private Date approvedate;

    private String approveidea;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getWenhao() {
        return wenhao;
    }

    public void setWenhao(String wenhao) {
        this.wenhao = wenhao == null ? null : wenhao.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFilenamedisk() {
        return filenamedisk;
    }

    public void setFilenamedisk(String filenamedisk) {
        this.filenamedisk = filenamedisk == null ? null : filenamedisk.trim();
    }

    public String getAttachfilenamedisk() {
        return attachfilenamedisk;
    }

    public void setAttachfilenamedisk(String attachfilenamedisk) {
        this.attachfilenamedisk = attachfilenamedisk == null ? null : attachfilenamedisk.trim();
    }

    public String getAttachfiledescribe() {
        return attachfiledescribe;
    }

    public void setAttachfiledescribe(String attachfiledescribe) {
        this.attachfiledescribe = attachfiledescribe == null ? null : attachfiledescribe.trim();
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Integer getApproveuser() {
        return approveuser;
    }

    public void setApproveuser(Integer approveuser) {
        this.approveuser = approveuser;
    }

    public Date getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(Date approvedate) {
        this.approvedate = approvedate;
    }

    public String getApproveidea() {
        return approveidea;
    }

    public void setApproveidea(String approveidea) {
        this.approveidea = approveidea == null ? null : approveidea.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
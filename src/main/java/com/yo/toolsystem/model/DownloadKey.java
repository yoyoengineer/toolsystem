package com.yo.toolsystem.model;

public class DownloadKey {
    private String usernum;

    private Integer toolid;

    public DownloadKey(String usernum, Integer toolid) {
        this.usernum = usernum;
        this.toolid = toolid;
    }

    public DownloadKey() {
        super();
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    public Integer getToolid() {
        return toolid;
    }

    public void setToolid(Integer toolid) {
        this.toolid = toolid;
    }
}
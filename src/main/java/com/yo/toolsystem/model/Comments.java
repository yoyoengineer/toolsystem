package com.yo.toolsystem.model;

import java.util.Date;

public class Comments {
    private Integer id;

    private String usernum;

    private Integer toolid;

    private String contents;

    private Date commentstime;

    private String username;

    public Comments(Integer id, String usernum, Integer toolid, String contents, Date commentstime, String username) {
        this.id = id;
        this.usernum = usernum;
        this.toolid = toolid;
        this.contents = contents;
        this.commentstime = commentstime;
        this.username = username;
    }

    public Comments() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public Date getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(Date commentstime) {
        this.commentstime = commentstime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
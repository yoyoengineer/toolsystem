package com.yo.toolsystem.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Yoy on 2017/4/23.
 */
public class PersonDis {
    @NotNull
    private String usernum;

    private String password;

    private String category;

    @NotNull
    private String username;

    private String gender;

    private String avatordir;

    private String tooltypemanage="-1";

    public PersonDis(String usernum, String password, String category, String username, String gender, String avatordir) {
        this.usernum = usernum;
        this.password = password;
        this.category = category;
        this.username = username;
        this.gender = gender;
        this.avatordir = avatordir;
    }

    public PersonDis() {
        super();
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatordir() {
        return avatordir;
    }

    public void setAvatordir(String avatordir) {
        this.avatordir = avatordir == null ? null : avatordir.trim();
    }

    public String getTooltypemanage() {
        return tooltypemanage;
    }

    public void setTooltypemanage(String tooltypemanage) {
        this.tooltypemanage = tooltypemanage;
    }
}

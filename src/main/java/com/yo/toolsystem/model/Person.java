package com.yo.toolsystem.model;

import javax.validation.constraints.NotNull;

public class Person {
    @NotNull
    private String usernum;

    private String password;

    private Integer category;

    @NotNull
    private String username;

    private Integer gender;

    private String avatordir;

    private Integer tooltypemanage;

    public Person(String usernum, String password, Integer category, String username, Integer gender, String avatordir, Integer tooltypemanage) {
        this.usernum = usernum;
        this.password = password;
        this.category = category;
        this.username = username;
        this.gender = gender;
        this.avatordir = avatordir;
        this.tooltypemanage = tooltypemanage;
    }

    public Person() {
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatordir() {
        return avatordir;
    }

    public void setAvatordir(String avatordir) {
        this.avatordir = avatordir == null ? null : avatordir.trim();
    }

    public Integer getTooltypemanage() {
        return tooltypemanage;
    }

    public void setTooltypemanage(Integer tooltypemanage) {
        this.tooltypemanage = tooltypemanage;
    }
}
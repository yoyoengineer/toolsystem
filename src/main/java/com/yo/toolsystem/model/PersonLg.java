package com.yo.toolsystem.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Yoy on 2017/4/23.
 */
public class PersonLg {
    @NotNull
    private String usernum;
    @NotNull
    @Size(min=5,max=16)
    private String password;

    public PersonLg(String usernum, String password) {
        this.usernum = usernum;
        this.password = password;
    }

    public PersonLg() {
    }

    public String getUsernum() {
        return usernum;
    }

    public String getPassword() {
        return password;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

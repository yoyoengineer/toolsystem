package com.yo.toolsystem.model;

import java.util.Date;

/**
 * Created by Yoy on 2017/4/29.
 */
public class ToolsDisplay {
    private Integer id;

    private String toolname;

    private String category;

    private String version;

    private String directory;

    private Date uploadtime;

    private String publisher;

    private Integer likenum;

    private Integer downloadtimes;

    private String description;

    private String tooltags;

    private String systemsupport;

    private String sizeoftool;

    public ToolsDisplay() {
    }

    public ToolsDisplay(Integer id, String toolname, String category, String version, String directory, Date uploadtime, String publisher, Integer likenum, Integer downloadtimes, String description, String tooltags, String systemsupport, String sizeoftool) {
        this.id = id;
        this.toolname = toolname;
        this.category = category;
        this.version = version;
        this.directory = directory;
        this.uploadtime = uploadtime;
        this.publisher = publisher;
        this.likenum = likenum;
        this.downloadtimes = downloadtimes;
        this.description = description;
        this.tooltags = tooltags;
        this.systemsupport = systemsupport;
        this.sizeoftool = sizeoftool;
    }

    public Integer getId() {
        return id;
    }

    public String getToolname() {
        return toolname;
    }

    public String getCategory() {
        return category;
    }

    public String getVersion() {
        return version;
    }

    public String getDirectory() {
        return directory;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public Integer getDownloadtimes() {
        return downloadtimes;
    }

    public String getDescription() {
        return description;
    }

    public String getTooltags() {
        return tooltags;
    }

    public String getSystemsupport() {
        return systemsupport;
    }

    public String getSizeoftool() {
        return sizeoftool;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public void setDownloadtimes(Integer downloadtimes) {
        this.downloadtimes = downloadtimes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTooltags(String tooltags) {
        this.tooltags = tooltags;
    }

    public void setSystemsupport(String systemsupport) {
        this.systemsupport = systemsupport;
    }

    public void setSizeoftool(String sizeoftool) {
        this.sizeoftool = sizeoftool;
    }

    @Override
    public int hashCode() {
        return this.getId()*345;
    }

    @Override
    public boolean equals(Object obj) {
        ToolsDisplay ob = (ToolsDisplay) obj;
        return ob.getId()==this.getId();
    }
}

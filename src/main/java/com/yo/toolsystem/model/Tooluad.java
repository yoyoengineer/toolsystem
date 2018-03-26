package com.yo.toolsystem.model;

import java.util.Date;

public class Tooluad {
    private Integer id;

    private String toolname;

    private Integer category;

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

    public Tooluad(Integer id, String toolname, Integer category, String version, String directory, Date uploadtime, String publisher, Integer likenum, Integer downloadtimes, String description, String tooltags, String systemsupport, String sizeoftool) {
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

    public Tooluad() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname == null ? null : toolname.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory == null ? null : directory.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getDownloadtimes() {
        return downloadtimes;
    }

    public void setDownloadtimes(Integer downloadtimes) {
        this.downloadtimes = downloadtimes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTooltags() {
        return tooltags;
    }

    public void setTooltags(String tooltags) {
        this.tooltags = tooltags == null ? null : tooltags.trim();
    }

    public String getSystemsupport() {
        return systemsupport;
    }

    public void setSystemsupport(String systemsupport) {
        this.systemsupport = systemsupport == null ? null : systemsupport.trim();
    }

    public String getSizeoftool() {
        return sizeoftool;
    }

    public void setSizeoftool(String sizeoftool) {
        this.sizeoftool = sizeoftool == null ? null : sizeoftool.trim();
    }
}
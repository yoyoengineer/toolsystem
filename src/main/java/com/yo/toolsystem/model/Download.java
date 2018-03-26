package com.yo.toolsystem.model;

public class Download extends DownloadKey {
    private String pathserver;

    private String pathclient;

    private Integer startpos;

    public Download(String usernum, Integer toolid, String pathserver, String pathclient, Integer startpos) {
        super(usernum, toolid);
        this.pathserver = pathserver;
        this.pathclient = pathclient;
        this.startpos = startpos;
    }

    public Download() {
        super();
    }

    public String getPathserver() {
        return pathserver;
    }

    public void setPathserver(String pathserver) {
        this.pathserver = pathserver == null ? null : pathserver.trim();
    }

    public String getPathclient() {
        return pathclient;
    }

    public void setPathclient(String pathclient) {
        this.pathclient = pathclient == null ? null : pathclient.trim();
    }

    public Integer getStartpos() {
        return startpos;
    }

    public void setStartpos(Integer startpos) {
        this.startpos = startpos;
    }
}
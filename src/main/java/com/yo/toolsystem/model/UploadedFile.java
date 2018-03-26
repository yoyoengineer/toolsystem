package com.yo.toolsystem.model;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Yoy on 2017/4/27.
 */
public class UploadedFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private String directory;
    private String category="";
    private String description="";
    private boolean complete = false;
    private String name="";
    private String version="";
    private String publisher;
    private String tags;
    private File file;
    private String systemSupport;

    public UploadedFile(){}

    public UploadedFile(String directory, String fileName){
        File dir = new File(directory);
        System.out.println("dir:"+dir);
        if(!dir.exists()){
            dir.mkdirs();
        }
        this.directory = dir.getAbsolutePath();
        this.file = new File(directory+"\\"+fileName);
        this.name = fileName;
    }

    public void setDirectory(String path){
        this.directory = path;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setSystemSupport(String systemSupport) {
        this.systemSupport = systemSupport;
    }

    public String getSystemSupport() {
        return systemSupport;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDirectory(){
        return this.directory;
    }

    public boolean isComplete(){
        return this.complete;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public String getName(){
        return this.name;
    }

    public void setVersion(String version){
        this.version = version;
    }

    public String getVersion(){
        return this.version;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile(){
        return this.file;
    }
}

package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.model.UploadedFile;
import com.yo.toolsystem.service.ToolManager;
import com.yo.toolsystem.service.UploadTool;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yoy on 2017/4/27.
 */
public class TaskBean implements Runnable, Serializable {
    private UploadTool uploadTool;
    private ToolManager toolManager;
    private long counter=0;
    private boolean running=false;
    private BufferedInputStream input=null;
    private BufferedOutputStream output=null;
    private long contentSize=0 ;
    private UploadedFile file = null;
    private int r = 0;
    private String path;


    public TaskBean(){}

//    public TaskBean(Part source, UploadedFile destination){
    public TaskBean(MultipartFile source, UploadedFile destination, UploadTool uploadTool, ToolManager toolManager, String path){
        this.path = path;
        this.uploadTool = uploadTool;
        this.toolManager = toolManager;
        file = destination;
        if(source!=null)
            this.contentSize=source.getSize();
        try{
            this.input = new BufferedInputStream(source.getInputStream());
            this.output = new BufferedOutputStream(new FileOutputStream(destination.getFile()));
        }
        catch(IOException e){
            output = null;
            input = null;
            e.printStackTrace();
        }
    }

    protected void upload(){
        if(input!=null && output!=null){
            try {
                if((r = input.read())!=-1){
                    counter++;
                    output.write((byte)r);
                }

            } catch (IOException e) {
                setRunning(false);
                e.printStackTrace();
            }
        }
        else{

            setRunning(false);
        }
    }

    public synchronized int  getPercentage(){
        return (int)((double)counter / contentSize * 100);
    }


    public synchronized boolean isCompleted(){
        return counter == contentSize && r == -1;
    }

    public synchronized boolean isRunning(){
        return running;
    }

    public synchronized void setRunning(boolean running){
        this.running = running;
    }

    public void run(){
        setRunning(true);
        while(isRunning() && !isCompleted() && contentSize!=0){
            upload();
        }
        setRunning(false);
        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isCompleted()){
            System.out.println("file.getDirectory():"+file.getDirectory());
            File directoryToBeDeleted = new File(file.getDirectory());
            Tooluad tools = new Tooluad();
            long now = System.currentTimeMillis();
            Date time=new Date(now);
            tools.setUploadtime(time);
            tools.setDirectory(path);
            tools.setToolname(file.getName());
            tools.setPublisher(file.getPublisher());
            tools.setDescription(file.getDescription());
            tools.setCategory(Integer.parseInt(file.getCategory()));
            tools.setVersion(file.getVersion());
            tools.setTooltags(file.getTags());
            tools.setSystemsupport(file.getSystemSupport());
            List<String> sizeUnit= new ArrayList<String>();
            sizeUnit.add("bytes");
            sizeUnit.add("KB");
            sizeUnit.add("MB");
            sizeUnit.add("GB");
            int su = 0;
            double sizeT = this.contentSize;
            while(sizeT>1024){
                sizeT/=1024;
                su++;
            }
            String u;
            switch (su){
                case 0:
                    u = sizeUnit.get(0);
                    break;
                case 1:
                    u = sizeUnit.get(1);
                    break;
                case 2:
                    u = sizeUnit.get(2);
                    break;
                default:
                    u = sizeUnit.get(3);
            }
            int sizeend = (int) sizeT;
            tools.setSizeoftool(String.valueOf(sizeend)+u);
            r = uploadTool.insertToolRecord(tools);
            if (r>0){
//                try {
//                    new PrintWriter(new File(file.getDirectory()+"/comments.txt"));
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
            }else {
                if(directoryToBeDeleted!=null){
                    toolManager.deleteFile(new File(file.getDirectory()));
                }
            }
        }
    }

    public UploadedFile getFile(){
        return file;
    }
}

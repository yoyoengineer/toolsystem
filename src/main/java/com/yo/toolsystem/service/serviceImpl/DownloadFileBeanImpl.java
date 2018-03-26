package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.DownloadMapper;
import com.yo.toolsystem.dao.TooluadMapper;
import com.yo.toolsystem.model.Download;
import com.yo.toolsystem.model.DownloadKey;
import com.yo.toolsystem.service.ToolManager;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yoy on 2017/4/25.
 */
public class DownloadFileBeanImpl implements Runnable, Serializable{
    @Resource
    private DownloadMapper downloadMapper;
//    @Resource
    private DownloadKey downloadKey;
    private boolean running = false;
    private String filename;
    private String targetPath;
    private long length;
    private long nStartPos;
    private File file;
    private int nRead = 0;
    private String sSiteURL; // Site's URL
    FileAccessI fileAccessI = null; // File Access interface
    private int i=1;
    private String usernum;
    private Integer toolid;
    private String pathserver;
    private String userAgent;
    private HttpURLConnection httpConnection;
    private Download download;
    private ToolManager toolManager;
//    private DownloadManagerImpl downloadManager;

    public DownloadFileBeanImpl() {

    }

    public DownloadFileBeanImpl(ToolManager toolManager) {
        this.toolManager = toolManager;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public void setToolid(Integer toolid) {
        this.toolid = toolid;
    }

    public void setPathserver(String pathserver) {
        this.pathserver = pathserver;
    }

    public int getPercentage() {
        return (int)((double)nStartPos / length * 100);
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running,DownloadMapper downloadMapper) {
        downloadMapper=downloadMapper;
        this.running = running;
        if(!running&&!isCompleted()){
            download = new Download();
            download.setStartpos((int) nStartPos);
            download.setUsernum(usernum);
            download.setPathclient(targetPath);
            download.setPathserver(pathserver);
            download.setToolid(toolid);
//            try {
//                fileAccessI.getoSavedFile().close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            System.out.println("nStartPos:"+download.getStartpos()+" usernum: "+download.getUsernum()+" targetPath:"+download.getPathclient()+" pathserver:"+download.getPathserver()+" Toolid:"+download.getToolid());
            System.out.println("running:"+running);
            downloadKey = new DownloadKey();
            downloadKey.setToolid(download.getToolid());
            downloadKey.setUsernum(download.getUsernum());
            if(downloadMapper.selectByPrimaryKey(downloadKey)!=null){
                downloadMapper.deleteByPrimaryKey(downloadKey);
            }
//            System.out.println(downloadMapper);
            downloadMapper.insertSelective(download);

//            System.out.println("nStartPos:"+nStartPos);
//            System.out.println("i----"+i);
//            i++;
//            downloadService.add(download);
        }
    }

    public FileAccessI getFileAccessI() {
        return fileAccessI;
    }

    public long getnStartPos() {
        return nStartPos;
    }

    public void setnStartPos(long nStartPos) {
        this.nStartPos = nStartPos;
    }

    public String getsSiteURL() {
        return sSiteURL;
    }

    public void setsSiteURL(String sSiteURL) {
        this.sSiteURL = sSiteURL;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public boolean isCompleted() {
        return nStartPos == length || nRead == -1;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Integer getToolid() {
        return toolid;
    }

    public void getConnection(){
        URL url = null;
        try{
            url = new URL(sSiteURL);
            System.out.println("sSiteURL;"+sSiteURL);

            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestProperty("User-Agent",userAgent);
            String sProperty = "bytes=" + nStartPos + "-";
            System.out.println("sProperty:"+sProperty+" length:"+this.length);
            httpConnection.setRequestProperty("RANGE", sProperty);
            }catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void setDownloadMapper(DownloadMapper downloadMapper) {
        this.downloadMapper = downloadMapper;
    }

    public void run() {
        setRunning(true,downloadMapper);
        String sName = targetPath + File.separator + filename + "";
        try {
            System.out.println(sName);
            fileAccessI = new FileAccessI(sName, nStartPos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.getsSiteURL());
        this.getConnection();
        try {
            InputStream input = httpConnection.getInputStream();
            byte[] b = new byte[1024];
            int nRead=0;
            while (isRunning() && !isCompleted()) {
                if ((nRead = input.read(b, 0, 1024)) > 0) {
                    nStartPos += fileAccessI.write(b, 0, nRead);
                }
            }
            fileAccessI.getoSavedFile().close();
            if (isCompleted()){
                downloadKey = new DownloadKey();
                downloadKey.setUsernum(usernum);
                downloadKey.setToolid(toolid);
                System.out.println("usernum:"+usernum+"toolid:"+toolid);
                toolManager.updateDownloadtime(toolid);
                 if (downloadMapper.selectByPrimaryKey(downloadKey)!=null){
                    downloadMapper.deleteByPrimaryKey(downloadKey);
                }
//                DownloadManagerImpl downloadManager = new DownloadManagerImpl();
//                downloadManager.deleteDownloadRecordByPrimaryKey(downloadKey);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

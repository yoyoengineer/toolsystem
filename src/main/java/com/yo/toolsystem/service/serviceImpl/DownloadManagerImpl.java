package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.DownloadMapper;
import com.yo.toolsystem.model.Download;
import com.yo.toolsystem.model.DownloadKey;
import com.yo.toolsystem.service.DownloadManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yoy on 2017/4/29.
 */
@Service
public class DownloadManagerImpl implements DownloadManager{
    @Resource
    private DownloadMapper downloadMapper;

    public String getPathClient(String userNum,int ToolID){
        DownloadKey downloadKey  = new DownloadKey();
        downloadKey.setToolid(ToolID);
        downloadKey.setUsernum(userNum);
        Download download = downloadMapper.selectByPrimaryKey(downloadKey);
        return download.getPathclient();
    }

    public boolean deleteDownloadRecordByPrimaryKey(DownloadKey downloadKey) {
        downloadMapper.deleteByPrimaryKey(downloadKey);
        return true;
    }
}

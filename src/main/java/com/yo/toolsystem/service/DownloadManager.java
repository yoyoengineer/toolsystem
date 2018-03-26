package com.yo.toolsystem.service;

import com.yo.toolsystem.model.DownloadKey;

/**
 * Created by Yoy on 2017/4/29.
 */
public interface DownloadManager {
    String getPathClient(String userNum,int ToolID);
    boolean deleteDownloadRecordByPrimaryKey(DownloadKey downloadKey);
}

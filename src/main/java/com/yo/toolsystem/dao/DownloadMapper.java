package com.yo.toolsystem.dao;

import com.yo.toolsystem.model.Download;
import com.yo.toolsystem.model.DownloadKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadMapper {
    int deleteByPrimaryKey(DownloadKey key);

    int insert(Download record);

    int insertSelective(Download record);

    Download selectByPrimaryKey(DownloadKey key);

    List<Download> selectByUserNum(String userNum);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);

    int selectUnfinishedToolsNum(String usernum);

}
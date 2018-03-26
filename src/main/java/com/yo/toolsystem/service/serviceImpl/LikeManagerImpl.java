package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.TooluadMapper;
import com.yo.toolsystem.service.LikeManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yoy on 2017/4/30.
 */
@Service
public class LikeManagerImpl implements LikeManager{
    @Resource
    TooluadMapper tooluadMapper;
    public boolean addLike(int ToolId) {
        tooluadMapper.updateLikeNumByPrimaryKey(ToolId);
        return false;
    }
}

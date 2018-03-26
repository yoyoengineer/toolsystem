package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.CommentsMapper;
import com.yo.toolsystem.model.Comments;
import com.yo.toolsystem.service.CommentsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Yoy on 2017/4/29.
 */
@Service
public class CommentsManagerImpl implements CommentsManager{
    @Resource
    private CommentsMapper commentsMapper;
    public boolean addComments(Integer toolid, String usernum, String contents,String userName) {
        long now = System.currentTimeMillis();
        Date time=new Date(now);
        Comments comments = new Comments();
        comments.setToolid(toolid);
        comments.setCommentstime(time);
        comments.setContents(contents);
        comments.setUsernum(usernum);
        comments.setUsername(userName);
        commentsMapper.insertSelective(comments);
        return true;
    }

    public List<Comments> selectCommentsByToolId(int toolId) {
        return commentsMapper.selectByToolId(toolId);
    }
}

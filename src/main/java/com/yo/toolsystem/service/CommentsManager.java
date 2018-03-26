package com.yo.toolsystem.service;

import com.yo.toolsystem.model.Comments;

import java.util.List;

/**
 * Created by Yoy on 2017/4/29.
 */
public interface CommentsManager {
    boolean addComments(Integer toolid,String usernum,String contents,String userName);
    List<Comments> selectCommentsByToolId(int toolId);
}

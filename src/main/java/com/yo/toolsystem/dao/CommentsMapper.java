package com.yo.toolsystem.dao;

import com.yo.toolsystem.model.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    List<Comments> selectByToolId(Integer ToolId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}
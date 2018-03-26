package com.yo.toolsystem.dao;

import com.yo.toolsystem.model.Toolcategory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToolcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Toolcategory record);

    int insertSelective(Toolcategory record);

    Toolcategory selectByPrimaryKey(Integer id);

    List<Toolcategory> selectAll();

    int updateByPrimaryKeySelective(Toolcategory record);

    int updateByPrimaryKey(Toolcategory record);
}
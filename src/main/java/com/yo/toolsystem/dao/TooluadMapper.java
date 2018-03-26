package com.yo.toolsystem.dao;

import com.yo.toolsystem.model.Tooluad;

import java.util.List;
import java.util.Map;

public interface TooluadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tooluad record);

    int insertSelective(Tooluad record);

    Tooluad selectByPrimaryKey(Integer id);

    List<Tooluad> selectByName(String toolname);

    List<Tooluad> selectByDescription(String description);

    List<Tooluad> selectByTag(String tag);

    List<Tooluad> selectByPubilsher(String pubilsher);

    List<Tooluad> selectByToolTypeId(Map<String, Object> map);

    List<Tooluad> selectAll();

    int selectToolTpyeByByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tooluad record);

    int updateByPrimaryKey(Tooluad record);

    void updateLikeNumByPrimaryKey(Integer id);

    int selectAllToolsNum();

    List<Tooluad> selectAllTools(Map<String, Object> map);

    int selectByToolTypeIdNum(int typeId);

    int selectToolsNumBySearch(String word);

    List<Tooluad> searchTools(Map<String, Object> map);

    void updateDownloadtime(Integer id);
}
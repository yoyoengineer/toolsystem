package com.yo.toolsystem.service;

import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;

import java.util.List;

/**
 * Created by Yoy on 2017/4/29.
 */
public interface SearchManager {
    List<String> separatesWords(String source);
    List<Tooluad> searchByName(String toolName);
    List<Tooluad> searchByDescription(String description);
    List<Tooluad> searchByTags(String tag);
    List<Tooluad> searchByToolTypeId(int typeId, Pager<ToolsDisplay> pager);
    List<Tooluad> searchByPubilsher(String pubilsher);
    List<Tooluad> searchTools(String source);
    int searchByToolTypeIdNum(int typeId);
    int searchToolsNum(String source);
    List<Tooluad> searchTools(String source,Pager<ToolsDisplay> pager);
}

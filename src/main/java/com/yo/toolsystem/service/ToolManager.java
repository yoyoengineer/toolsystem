package com.yo.toolsystem.service;


import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;

import java.io.File;
import java.util.List;

/**
 * Created by Yoy on 2017/4/26.
 */
public interface ToolManager {
    List<Tooluad> selectAllTools();
    boolean deleteFile(File directoryToBeDeleted);
    int selectToolTpye(int id);
    Tooluad selectToolByPrimaryKey(int id);
    String selectToolDirectory(int id);
    String selectToolName(int id);
    ToolsDisplay getDisplayTool(Tooluad tooluad);
    List<ToolsDisplay> getDisplayTools(List<Tooluad> tooluads);
    boolean deleteToolRecordByPrimaryKey(int id);
    int selectAllToolsNum();
    List<ToolsDisplay> getDisplayTools(Pager<ToolsDisplay> pager);
    boolean updateDownloadtime(int toolId);
}

package com.yo.toolsystem.service;

import com.yo.toolsystem.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Yoy on 2017/5/3.
 */
public interface Paging {
    Pager getToolsPager(int currentPage,int pageSize);
    Pager<ToolsDisplay> getToolsPagerByType(int currentPage, int pageSize, int typeId);
    Pager<ToolsDisplay> searchTools(int currentPage, int pageSize, String words);
    Pager getUnfinishedTools(int currentPage,int pageSize,HttpServletRequest request);
    Pager getPeoplePager(int currentPage, int pageSize);
    Pager<PersonDis> getUsersPager(int currentPage, int pageSize);

}

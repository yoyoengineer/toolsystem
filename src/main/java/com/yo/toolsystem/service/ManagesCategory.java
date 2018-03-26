package com.yo.toolsystem.service;

import com.yo.toolsystem.model.Toolcategory;

import java.util.List;

/**
 * Created by Yoy on 2017/4/23.
 */
public interface ManagesCategory {
    boolean insertCategory(Toolcategory toolcategory);
    List<Toolcategory> selectAllCategory();
    boolean saveCategoryId(int id);
    int getCategoryId();
    boolean editToolCategory(Toolcategory toolcategory);
    boolean deleteToolType(int toolId);
    String selectCategoryById(int id);
}

package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.ToolcategoryMapper;
import com.yo.toolsystem.model.Toolcategory;
import com.yo.toolsystem.service.ManagesCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yoy on 2017/4/23.
 */
@Service
public class ManagesCategoryImpl implements ManagesCategory {
    @Resource
    private ToolcategoryMapper toolcategoryMapper;
    private int id;
    public boolean insertCategory(Toolcategory toolcategory) {
        toolcategoryMapper.insertSelective(toolcategory);
        return true;
    }

    public List<Toolcategory> selectAllCategory() {
        return toolcategoryMapper.selectAll();
    }

    public boolean saveCategoryId(int id) {
        this.id=id;
        return true;
    }

    public int getCategoryId() {
        return id;
    }

    public boolean editToolCategory(Toolcategory toolcategory) {
        toolcategoryMapper.updateByPrimaryKey(toolcategory);
        return true;
    }

    public boolean deleteToolType(int toolId){
        toolcategoryMapper.deleteByPrimaryKey(toolId);
        return true;
    }

    public String selectCategoryById(int id) {
//        System.out.println("id:---"+id);
        Toolcategory toolcategory = toolcategoryMapper.selectByPrimaryKey(id);
//        System.out.println("dfds:"+toolcategory);
        String category = toolcategory.getCategory();
//        System.out.println("category:"+category);
        return category;
    }
}

package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.TooluadMapper;
import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.ToolManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoy on 2017/4/26.
 */
@Service
public class ToolManagerImpl implements ToolManager{
    @Resource
    private TooluadMapper toolsMapper;
    @Resource
    ManagesCategory managesCategory;
    public List<Tooluad> selectAllTools() {
        return toolsMapper.selectAll();
    }

    public boolean deleteFile(File directoryToBeDeleted) {
        if(directoryToBeDeleted!=null){
//            System.out.println("---2---");
            File[] childFiles = directoryToBeDeleted.listFiles();
            if(childFiles!=null){
//                System.out.println("---3---");
                for(int i=0;i< childFiles.length ;i++){
                    childFiles[i].delete();
                }
//                System.out.println("childFiles.length:"+childFiles.length);
            }
            if(directoryToBeDeleted!=null){
                directoryToBeDeleted.delete();
            }
//            System.out.println("Deleted");
        }
        return true;
    }

    public int selectToolTpye(int id){
        return toolsMapper.selectToolTpyeByByPrimaryKey(id);
    }

    public Tooluad selectToolByPrimaryKey(int id) {
//        System.out.println("id:"+id);
        return toolsMapper.selectByPrimaryKey(id);
    }

    public String selectToolDirectory(int id) {
        return this.selectToolByPrimaryKey(id).getDirectory();
    }

    public String selectToolName(int id) {
        return this.selectToolByPrimaryKey(id).getToolname();
    }

    public ToolsDisplay getDisplayTool(Tooluad tooluad) {
        ToolsDisplay toolsDisplay = new ToolsDisplay();
        toolsDisplay.setSizeoftool(tooluad.getSizeoftool());
        toolsDisplay.setDirectory(tooluad.getDirectory());
        toolsDisplay.setToolname(tooluad.getToolname());
        toolsDisplay.setDescription(tooluad.getDescription());
        toolsDisplay.setId(tooluad.getId());
        toolsDisplay.setLikenum(tooluad.getLikenum());
        toolsDisplay.setDownloadtimes(tooluad.getDownloadtimes());
        toolsDisplay.setPublisher(tooluad.getPublisher());
        toolsDisplay.setSystemsupport(tooluad.getSystemsupport());
        toolsDisplay.setTooltags(tooluad.getTooltags());
        toolsDisplay.setVersion(tooluad.getVersion());
        toolsDisplay.setUploadtime(tooluad.getUploadtime());
//        System.out.println("tooluad.getCategory():"+tooluad.getCategory());
        toolsDisplay.setCategory(managesCategory.selectCategoryById(tooluad.getCategory()));
        return toolsDisplay;
    }

    public List<ToolsDisplay> getDisplayTools(List<Tooluad> tooluads) {
//        System.out.println("size::::"+tooluads.size());
        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        System.out.println("---");
        for (Tooluad tooluad:tooluads){
//            System.out.println("toolsDisplays"+toolsDisplays.size());
            ToolsDisplay toolsDisplay = this.getDisplayTool(tooluad);
//            System.out.println("-*-*");
            toolsDisplays.add(toolsDisplay);
        }
//        System.out.println("toolsDisplays.size:"+toolsDisplays.size());
        return toolsDisplays;
    }

    public boolean deleteToolRecordByPrimaryKey(int id) {
        toolsMapper.deleteByPrimaryKey(id);
        return true;
    }

    public int selectAllToolsNum() {
        return toolsMapper.selectAllToolsNum();
    }

    public List<ToolsDisplay> getDisplayTools(Pager<ToolsDisplay> pager) {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("start",(pager.getCurrentPage()-1)*pager.getPageSize());
        map.put("start",pager.getFromIndex());
        map.put("size",pager.getPageSize());
//        System.out.println("start:"+pager.getFromIndex()+"size"+pager.getPageSize());
//        System.out.println("size::"+toolsMapper.selectAllTools(map).size());
        return this.getDisplayTools(toolsMapper.selectAllTools(map));
    }

    public boolean updateDownloadtime(int toolId) {
//        System.out.println("gongju:"+toolId);
        toolsMapper.updateDownloadtime(toolId);
        return false;
    }
}

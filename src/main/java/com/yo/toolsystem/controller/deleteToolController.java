package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.ToolManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoy on 2017/4/30.
 */
@Controller
public class deleteToolController {
    @Resource
    private ToolManager toolManager;
    @Resource
    private ManagesCategory managesCategory;

    @RequestMapping(value = "deleteTool/{toolId}", method = RequestMethod.GET)
    public String deleteTool(@PathVariable int toolId,HttpServletRequest request){
        String directory =  request.getSession().getServletContext().getRealPath("/")+toolManager.selectToolByPrimaryKey(toolId).getDirectory();
        toolManager.deleteFile(new File(directory));
        toolManager.deleteToolRecordByPrimaryKey(toolId);
        return "redirect:/managesToolsDisplay";
    }

//    @RequestMapping(value = "managesToolsDisplay", method = RequestMethod.GET)
//    public String managesToolsDisplay(Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = toolManager.selectAllTools();
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        model.addAttribute("tools",toolsDisplays);
//        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        return "toolsDisplayForManager";
//    }

    @RequestMapping(value = "deleteToolBySubManager/{toolId}", method = RequestMethod.GET)
    public String deleteToolBySubManager(@PathVariable int toolId,HttpServletRequest request){
        String directory =  request.getSession().getServletContext().getRealPath("/")+toolManager.selectToolByPrimaryKey(toolId).getDirectory();
        toolManager.deleteFile(new File(directory));
        toolManager.deleteToolRecordByPrimaryKey(toolId);
        return "redirect:/subManagerPage";
    }
}

package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.ToolsDisplay;
import com.yo.toolsystem.model.Tooluad;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.Paging;
import com.yo.toolsystem.service.SearchManager;
import com.yo.toolsystem.service.ToolManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yoy on 2017/4/29.
 */
@Controller
//@Scope("prototype")
public class searchController {
    @Resource
    private SearchManager searchManager;
    @Resource
    private ToolManager toolManager;
    @Resource
    private ManagesCategory managesCategory;
    @Resource
    private Paging paging;
//    @Resource
    private Pager<ToolsDisplay> pager  = new Pager<ToolsDisplay>();
    @RequestMapping(value = "searchTools", method = RequestMethod.POST)
    public String searchTools(String search,Model model){
        pager = paging.searchTools(1,10,search);
        System.out.println("size:"+pager.getDataList().size());
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = searchManager.searchTools(search);
//        System.out.println("tooluads.size():"+tooluads.size());
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        Set<ToolsDisplay> toolsDisplaySet = new HashSet<ToolsDisplay>();
//        for (ToolsDisplay toolsDisplay: toolsDisplays){
//            toolsDisplaySet.add(toolsDisplay);
//        }
//        System.out.println("toolsDisplays.size():"+toolsDisplays.size());
//        System.out.println("toolsDisplaySet.size()"+toolsDisplaySet.size());
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        model.addAttribute("tools",toolsDisplaySet);
        model.addAttribute("pager",pager);
        return "toolDisplay";
    }
}

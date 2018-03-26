package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.*;
import com.yo.toolsystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoy on 2017/4/30.
 */
@Controller
public class SubManagerController {
    @Resource
    private ToolManager toolManager;
    @Resource
    private SearchManager searchManager;
    @Resource
    private ManagesCategory managesCategory;
    @Resource
    private LikeManager likeManager;
    @Resource
    private Paging paging;
    private Pager<ToolsDisplay> pager;
    private List<Toolcategory> toolcategories;
    private List<ToolsDisplay> toolsDisplaysByTypeLink = new ArrayList<ToolsDisplay>();
    private List<Toolcategory> toolcategoriesByTypeLink = new ArrayList<Toolcategory>();

    @RequestMapping(value = "subManagerPage", method = RequestMethod.GET)
    public String toolDisplay(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        pager = paging.getToolsPager(1,10);
        Person person = (Person) session.getAttribute("person");
        if (person.getTooltypemanage()!=-1){
            return "redirect:displayByToolTypeForSubManager/"+person.getTooltypemanage();
        }
        model.addAttribute("manager",person);
        model.addAttribute("pager",pager);

//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = toolManager.selectAllTools();
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        model.addAttribute("tools",toolsDisplays);
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        return "subManager";
    }

    @RequestMapping(value = "displayByToolTypeForSubManager/{typeID}", method = RequestMethod.GET)
    public String displayByToolTypeForSubManager(@PathVariable int typeID, Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = searchManager.searchByToolTypeId(typeID);
        pager = paging.getToolsPagerByType(1,10,typeID);
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        toolsDisplaysByTypeLink = toolsDisplays;
        toolcategoriesByTypeLink = managesCategory.selectAllCategory();
        return "redirect:/displayByToolTypeResultsForSubManager";
    }

    @RequestMapping(value = "displayByToolTypeResultsForSubManager", method = RequestMethod.GET)
    public String displayByToolTypeResultsForSubManager(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
//        model.addAttribute("tools",toolsDisplaysByTypeLink);
        model.addAttribute("manager",person);
        model.addAttribute("pager",pager);
        model.addAttribute("toolTypes",toolcategoriesByTypeLink);
        return "subManager";
    }

    @RequestMapping(value = "pageDisplayForSub/{pageNum}", method = RequestMethod.GET)
    public String pageDisplayForSub(@PathVariable int pageNum,Model model){
        pager = paging.getToolsPager(pageNum,10);
        model.addAttribute("pager",pager);
        model.addAttribute("toolTypes",toolcategories);
        return "redirect:/displayToolsForSub";
    }

    @RequestMapping(value = "displayToolsForSub", method = RequestMethod.GET)
    public String displayToolsForSub(Model model){
        model.addAttribute("pager",pager);
        toolcategories = managesCategory.selectAllCategory();
        model.addAttribute("toolTypes",toolcategories);
        return "subManager";
    }
}

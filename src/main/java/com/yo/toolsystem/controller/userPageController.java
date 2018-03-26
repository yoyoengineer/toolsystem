package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.*;
import com.yo.toolsystem.service.*;
import com.yo.toolsystem.service.serviceImpl.ToolManagerImpl;
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
import java.util.Vector;

/**
 * Created by Yoy on 2017/4/26.
 */
@Controller
public class userPageController {
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
    private Pager<ToolsDisplay> pager = new Pager<ToolsDisplay>();
    private List<Toolcategory> toolcategories;
    private List<ToolsDisplay> toolsDisplaysByTypeLink = new ArrayList<ToolsDisplay>();
    private List<Toolcategory> toolcategoriesByTypeLink = new ArrayList<Toolcategory>();

    @RequestMapping(value = "toolsDisplay", method = RequestMethod.GET)
    public String toolDisplay(Model model,HttpServletRequest request){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = toolManager.selectAllTools();
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        System.out.println("toolsDisplays size"+toolsDisplays.size());
//        model.addAttribute("tools",toolsDisplays);
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        pager = paging.getToolsPager(1,10);
        model.addAttribute("pager",pager);
        toolcategories = managesCategory.selectAllCategory();
        model.addAttribute("toolTypes",toolcategories);
        if (person.getCategory()==2){
            return "redirect:subManagerPage";
        }else if (person.getCategory()==3){
            return "redirect:superManagerPage";
        }
        return "toolDisplay";
    }

    @RequestMapping(value = "pageDisplay/{pageNum}", method = RequestMethod.GET)
    public String pageDisplay(@PathVariable int pageNum,Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        System.out.println("pageNum:"+pageNum);
        pager = paging.getToolsPager(pageNum,10);
//        System.out.println("-----");
        model.addAttribute("pager",pager);
        model.addAttribute("toolTypes",toolcategories);
        return "redirect:/displayTools";
    }
    @RequestMapping(value = "displayTools", method = RequestMethod.GET)
    public String displayTools(Model model){
        model.addAttribute("pager",pager);
        toolcategories = managesCategory.selectAllCategory();
//        System.out.println("toolcategories.size():"+toolcategories.size());
        model.addAttribute("toolTypes",toolcategories);
        return "toolDisplay";
    }
    @RequestMapping(value = "displayByToolType/{typeID}", method = RequestMethod.GET)
    public String displayByToolType(@PathVariable int typeID,Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = searchManager.searchByToolTypeId(typeID);
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
        pager = paging.getToolsPagerByType(1,10,typeID);
//        toolsDisplaysByTypeLink = toolsDisplays;
        toolcategoriesByTypeLink = managesCategory.selectAllCategory();
        return "redirect:/displayByToolTypeResults";
    }

    @RequestMapping(value = "displayByToolTypeResults", method = RequestMethod.GET)
    public String displayByToolTypeResults(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        model.addAttribute("pager",pager);
//        model.addAttribute("tools",toolsDisplaysByTypeLink);
        model.addAttribute("toolTypes",toolcategoriesByTypeLink);
        if (person.getCategory()!=1){
            return "subManager";
        }
        return "toolDisplay";
    }

    @RequestMapping(value = "addLike/{toolId}", method = RequestMethod.GET)
    public String addLike(@PathVariable int toolId){
        likeManager.addLike(toolId);
        return "redirect:/toolDetailPage";
    }

    @RequestMapping(value = "myDownloadPage", method = RequestMethod.GET)
    public String myDownloadPage(Model model,HttpServletRequest request){
        pager = paging.getUnfinishedTools(1,10,request);
        model.addAttribute("pager",pager);
        toolcategories = managesCategory.selectAllCategory();
        model.addAttribute("toolTypes",toolcategories);
        return "myDownload";
    }

    @RequestMapping(value = "downloadDisplay/{pageNum}", method = RequestMethod.GET)
    public String downloadDisplay(@PathVariable int pageNum, Model model, HttpServletRequest request){
        pager = paging.getUnfinishedTools(pageNum,10,request);
//        model.addAttribute("pager",pager);
//        model.addAttribute("toolTypes",toolcategories);
        return "redirect:/displayDownloads";
    }

    @RequestMapping(value = "displayDownloads", method = RequestMethod.GET)
    public String displayDownloads(Model model){
        model.addAttribute("pager",pager);
        toolcategories = managesCategory.selectAllCategory();
        model.addAttribute("toolTypes",toolcategories);
        return "myDownload";
    }
}

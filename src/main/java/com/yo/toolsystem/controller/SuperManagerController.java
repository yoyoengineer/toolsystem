package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.*;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.ManagesPerson;
import com.yo.toolsystem.service.Paging;
import com.yo.toolsystem.service.ToolManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoy on 2017/4/23.
 */
@Controller
public class SuperManagerController {
    @Resource
    private ManagesPerson managesPerson;
    @Resource
    private ManagesCategory managesCategory;
    @Resource
    private ToolManager toolManager;
//    @Resource
    private Pager<PersonDis> pager = new Pager<PersonDis>();
    @Resource
    private Paging paging;

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(@Valid PersonDis personDis, Errors errors){
        if (!errors.hasErrors()){
            managesPerson.addUser(personDis);
        }
//        return "redirect:superManagerPage";
        return "redirect:managesUserPage";
    }

    @RequestMapping(value = "superManagerPage", method = RequestMethod.GET)
    public String SuperManager(Model model){
        pager = paging.getPeoplePager(1,10);
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        model.addAttribute("people",managesPerson.selectAll());
        model.addAttribute("pager",pager);
        return "superManager";
    }

    @RequestMapping(value = "subManagersDisplay", method = RequestMethod.GET)
    public String subManagerDisplay(Model model){
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        model.addAttribute("people",managesPerson.selectAll());
        model.addAttribute("pager",pager);
        return "superManager";
    }

    @RequestMapping(value = "usersDisplay", method = RequestMethod.GET)
    public String usersDisplay(Model model){
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        model.addAttribute("people",managesPerson.selectAll());
        model.addAttribute("pager",pager);
        return "managesUsers";
    }

    @RequestMapping(value = "addManager",method = RequestMethod.POST)
    public String superManager(@Valid PersonDis personDis, Errors errors){
        System.out.println(personDis.getTooltypemanage());
        if (!errors.hasErrors()){
            managesPerson.addManager(personDis);
        }
//        model.addAttribute("people",managesPerson.selectAll());
//        for (Person person:managesPerson.selectAll()){
//            System.out.println(person.getUsername());
//        }
        return "redirect:superManagerPage";
    }

    @RequestMapping(value = "managesUserPage", method = RequestMethod.GET)
    public String managesUser(Model model){
        pager = paging.getUsersPager(1,10);
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        model.addAttribute("pager",pager);
//        System.out.println("size:"+pager.getDataList().size());
        return "managesUsers";
    }

    @RequestMapping(value = "managesToolsBySuperManager", method = RequestMethod.GET)
//    public String managesToolsBySuperManager(Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        List<Tooluad> tooluads = toolManager.selectAllTools();
//        toolsDisplays = toolManager.getDisplayTools(tooluads);
//        model.addAttribute("tools",toolsDisplays);
//        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
//        return "toolsDisplayForManager";
    public String managesToolsBySuperManager(Model model){
        return "redirect:subManagerPage";
    }

    @RequestMapping(value = "personDisplay/{pageNum}", method = RequestMethod.GET)
    public String personDisplay(@PathVariable int pageNum, Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        System.out.println("pageNum:"+pageNum);
        pager = paging.getPeoplePager(pageNum,10);
//        System.out.println("-----");
//        model.addAttribute("pager",pager);
        return "redirect:/subManagersDisplay";
    }

    @RequestMapping(value = "usersDisplay/{pageNum}", method = RequestMethod.GET)
    public String usersDisplay(@PathVariable int pageNum, Model model){
//        List<ToolsDisplay> toolsDisplays = new ArrayList<ToolsDisplay>();
//        System.out.println("pageNum:"+pageNum);
        pager = paging.getUsersPager(pageNum,10);
//        System.out.println("-----");
//        model.addAttribute("pager",pager);
        return "redirect:/usersDisplay";
    }
}

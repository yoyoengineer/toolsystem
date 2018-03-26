package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Toolcategory;
import com.yo.toolsystem.service.ManagesCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Yoy on 2017/4/23.
 */
@Controller
public class CategoryController {
    @Resource
    ManagesCategory managesCategory;

    @RequestMapping(value = "manageCategory", method = RequestMethod.GET)
    public String manageCategory(Model model,HttpServletRequest request){
//        HttpSession session = request.getSession();
//        if (session.isNew()){
//            return "index";
//        }
        model.addAttribute("toolCategorys",managesCategory.selectAllCategory());
        return "manageCategory";
    }

    @RequestMapping(value = "editCategory/{categoryId}", method = RequestMethod.GET)
    public String editCategory(@PathVariable int categoryId){
        managesCategory.saveCategoryId(categoryId);
        return "redirect:/editCategoryPage";
    }

    @RequestMapping(value = "editCategoryPage", method = RequestMethod.GET)
    public String editCategoryPage(Model model){
        model.addAttribute("toolType",new Toolcategory());
        return "CategoryEdit";
    }

    @RequestMapping(value = "editCategory", method = RequestMethod.POST)
    public String editCategoryR(@Valid Toolcategory toolcategory, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "manageCategory";
        }else {
//            System.out.println("managesCategory.getCategoryId():"+managesCategory.getCategoryId());
            toolcategory.setId(managesCategory.getCategoryId());
            managesCategory.editToolCategory(toolcategory);
            return "redirect:/manageCategory";
        }
    }

    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    public String addCategory(@Valid Toolcategory toolcategory, Errors errors){
        if (!errors.hasErrors()){
            managesCategory.insertCategory(toolcategory);
        }
        return "redirect:manageCategory";
    }

    @RequestMapping(value = "deleteToolCategory/{typeId}", method = RequestMethod.GET)
    public String deleteBookTypePage(@PathVariable int typeId){
        managesCategory.deleteToolType(typeId);
        return "redirect:/manageCategory";
    }
}

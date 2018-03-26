package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.service.CommentsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Yoy on 2017/4/29.
 */
@Controller
public class CommentsController {
    @Resource
    private CommentsManager commentsManager;
    @RequestMapping(value = "comments",method = RequestMethod.POST)
    public String comments(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Person user = (Person) session.getAttribute("person");
        int toolId = Integer.parseInt(request.getParameter("toolId"));
        commentsManager.addComments(toolId,user.getUsernum(),request.getParameter("comment"),user.getUsername());
//        model.addAttribute("comments",commentsManager.selectCommentsByToolId(toolId));
        return "redirect:/toolDetailPage";
    }
}

package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonLg;
import com.yo.toolsystem.service.Login;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Yoy on 2017/4/22.
 */

@Controller
public class LogInController {
    @Resource
    private Login login;
    private int varifyNum;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@Valid PersonLg personLg, Errors errors,HttpServletRequest request){
//        System.out.println("personLg.getUsernum():"+personLg.getUsernum());
        varifyNum = login.verify(personLg);
//        System.out.println(varifyNum);
        Person person = new Person();
        HttpSession session = request.getSession();
        if (errors.hasErrors()||varifyNum==0){
            return "redirect:index";
        }else{
             person = login.selectPersonByPrimaryKey(personLg.getUsernum());
             session.setAttribute("person",person);
        }
        if (varifyNum==2){
            return "redirect:subManagerPage";
        }else if (varifyNum==3){
            return "redirect:superManagerPage";
        }else{
            return "redirect:toolsDisplay";
        }
    }

    @RequestMapping(value = "subManager", method = RequestMethod.GET)
    public String manager(){
        return "subManager";
    }

    @RequestMapping(value = "uploadTool", method = RequestMethod.GET)
    public String uploadTool(){
        return "uploadTool";
    }

//    @RequestMapping(value = "toolDisplay", method = RequestMethod.GET)
//    public String toolDisplay(){
//        return "toolDisplay";
//    }

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexG() {
        return "index";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("person");
        return "redirect:/";
    }
//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    public String test(){
//        return "downloading";
//    }
}

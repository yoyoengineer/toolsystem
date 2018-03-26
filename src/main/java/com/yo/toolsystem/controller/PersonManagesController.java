package com.yo.toolsystem.controller;

import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonDis;
import com.yo.toolsystem.service.ManagesCategory;
import com.yo.toolsystem.service.ManagesPerson;
import com.yo.toolsystem.service.Paging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Yoy on 2017/4/26.
 */
@Controller
public class PersonManagesController {
    @Resource
    private ManagesPerson managesPerson;
    @Resource
    private ManagesCategory managesCategory;
//    @Resource
    private Pager<Person> pager = new Pager<Person>();
    @Resource
    private Paging paging;
    @RequestMapping(value = "editPerson/{userNum}", method = RequestMethod.GET)
    public String editCategory(@PathVariable String userNum){
        managesPerson.saveUserNum(userNum);
        return "redirect:/editPersonPage";
    }

    @RequestMapping(value = "editPersonPage", method = RequestMethod.GET)
    public String editCategoryPage(Model model){
        model.addAttribute("personCategory",managesPerson.selectPersonByNum(managesPerson.getUerNum()).getCategory());
        model.addAttribute("person",new Person());
        model.addAttribute("toolTypes",managesCategory.selectAllCategory());
        return "personEdit";
    }

    @RequestMapping(value = "editPerson",method = RequestMethod.POST)
    public String editCategoryR(@Valid PersonDis personDis, Errors errors){
//    public String editCategoryR(Person person){
        if (errors.hasErrors()){
//            System.out.println("hasErrors");
//            System.out.println("person.getUsernum()"+personDis.getUsernum());
//            System.out.println("person.getUsername()"+personDis.getUsername());
            return "superManager";
        }else {
//            Person person = new Person();
            personDis.setUsernum(managesPerson.getUerNum());
//            person.setUsername(personDis.getUsername());
//            Integer.parseInt(personDis.getGender())
//            person.setGender();
//            System.out.println("managesPerson.getUerNum():"+managesPerson.getUerNum());
            managesPerson.editPerson(personDis);
            if (managesPerson.selectPersonByNum(personDis.getUsernum()).getCategory()==2){
                return "redirect:/superManagerPage";
            }
            else {
                return "redirect:/managesUserPage";
            }
        }
    }

    @RequestMapping(value = "editUser",method = RequestMethod.POST)
    public String editUser(@Valid PersonDis personDis, Errors errors){
        if (errors.hasErrors()){
            System.out.println("hasErrors");
            System.out.println("person.getUsernum()"+personDis.getUsernum());
            System.out.println("person.getUsername()"+personDis.getUsername());
            return "superManager";
        }else {
            managesPerson.editPerson(personDis);

            return "redirect:/superManagerPage";
        }
    }

    @RequestMapping(value = "deletePerson/{usernum}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable String usernum){
        if (managesPerson.selectPersonByNum(usernum).getCategory()==2){
            managesPerson.deletePerson(usernum);
            return "redirect:/superManagerPage";
        }
        else{
            managesPerson.deletePerson(usernum);
            return "redirect:/managesUserPage";
        }
    }

    @RequestMapping(value = "editPassWord", method = RequestMethod.POST)
    public  String editPassWord(@Valid PersonDis personDis,Errors errors){
        if (errors.hasErrors()){
            System.out.println("eee");
            return "index";
        }else {
            System.out.println(personDis.getPassword());
            managesPerson.editPassword(personDis);
            return "index";
        }
    }


}

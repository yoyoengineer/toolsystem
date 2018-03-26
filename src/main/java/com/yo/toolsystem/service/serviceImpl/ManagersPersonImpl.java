package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.PersonMapper;
import com.yo.toolsystem.dao.ToolcategoryMapper;
import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonDis;
import com.yo.toolsystem.service.ManagesPerson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoy on 2017/4/23.
 */
@Service
public class ManagersPersonImpl implements ManagesPerson{
    @Resource
    private PersonMapper personMapper;
    @Resource
    private ToolcategoryMapper toolcategoryMapper;
    private String userNum;

    private Person person = new Person();

    public boolean addUser(PersonDis personDis) {
        if (personDis.getGender().equals("男")||personDis.getGender().equals("man")){
            person.setGender(1);
        }else {
            person.setGender(0);
        }
        person.setUsername(personDis.getUsername());
        person.setUsernum(personDis.getUsernum());
        person.setPassword("000000");
        person.setCategory(1);
        personMapper.insertSelective(person);
        return true;
    }

    public boolean addManager(PersonDis personDis) {
        System.out.println(person.getGender());
        if (personDis.getGender().equals("男")||personDis.getGender().equals("man")){
            person.setGender(1);
        }else {
            person.setGender(0);
        }
        person.setUsername(personDis.getUsername());
        person.setUsernum(personDis.getUsernum());
        person.setPassword("000000");
        person.setCategory(2);

        person.setTooltypemanage(Integer.parseInt(personDis.getTooltypemanage()));
        personMapper.insertSelective(person);
        return true;
    }

    public List<Person> selectAll() {
        return personMapper.selectAll();
    }

    public boolean saveUserNum(String userNum) {
        this.userNum = userNum;
        return true;
    }

    public String getUerNum() {
        return this.userNum;
    }

    public boolean editPerson(PersonDis personDis) {
        Person personEdit = new Person();
        if (personDis.getGender().equals("男")||personDis.getGender().equals("man")){
            personEdit.setGender(1);
        }else {
            personEdit.setGender(0);
        }
        personEdit.setUsername(personDis.getUsername());
        personEdit.setUsernum(personDis.getUsernum());
        personEdit.setTooltypemanage(Integer.parseInt(personDis.getTooltypemanage()));
        personMapper.updateByPrimaryKeySelective(personEdit);
        return true;
    }

    public boolean editPassword(PersonDis personDis) {
        Person personEdit = new Person();
        personEdit.setUsername(personDis.getUsername());
        personEdit.setUsernum(personDis.getUsernum());
        personEdit.setPassword(personDis.getPassword());
        personMapper.updateByPrimaryKeySelective(personEdit);
        return false;
    }

    public boolean deletePerson(String userNum){
        personMapper.deleteByPrimaryKey(userNum);
        return true;
    }

    public Person selectPersonByNum(String Num) {
        return personMapper.selectByPrimaryKey(Num);
    }

    public List<Person> selectPeopleByPager(Pager<PersonDis> pager) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start",pager.getFromIndex());
        map.put("size",pager.getPageSize());
        map.put("category",2);
        return personMapper.selectPeopleByPager(map);
    }

    public PersonDis getPersonDis(Person person) {
        PersonDis personDis = new PersonDis();
        if (person.getCategory()!=null){
            if (person.getCategory()==1){
                personDis.setCategory("普通用户");
            }else if (person.getCategory()==2){
                personDis.setCategory("子管理员");
            }else {
                personDis.setCategory("最高管理员");
            }
        }
        personDis.setUsername(person.getUsername());
        personDis.setUsernum(person.getUsernum());
        if (person.getAvatordir()!=null){
            personDis.setAvatordir(person.getAvatordir());
        }
        if (person.getGender()!=null){
            if (person.getGender()==1){
                personDis.setGender("男");
            }else {
                personDis.setGender("女");
            }
        }
        if (person.getPassword()!=null){
            personDis.setPassword(person.getPassword());
        }
        if (person.getTooltypemanage()!=null){
            if (person.getTooltypemanage()==-1){
                personDis.setTooltypemanage("所有类别");
            }else {
                personDis.setTooltypemanage(toolcategoryMapper.selectByPrimaryKey(person.getTooltypemanage()).getCategory());
            }
//            System.out.println("person.getTooltypemanage():"+person.getTooltypemanage());
        }
        return personDis;
    }

    public List<PersonDis> getPeopleDis(List<Person> people) {
        List<PersonDis> peopleDis = new ArrayList<PersonDis>();
        for (Person person:people){
            peopleDis.add(this.getPersonDis(person));
        }
        return peopleDis;
    }

    public List<Person> selectUsersByPager(Pager<PersonDis> pager) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start",pager.getFromIndex());
        map.put("size",pager.getPageSize());
        map.put("category",1);
        return personMapper.selectPeopleByPager(map);
    }

}

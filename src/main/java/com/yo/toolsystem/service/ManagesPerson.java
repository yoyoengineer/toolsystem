package com.yo.toolsystem.service;

import com.yo.toolsystem.model.Pager;
import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonDis;

import java.util.List;

/**
 * Created by Yoy on 2017/4/23.
 */
public interface ManagesPerson {
    boolean addUser(PersonDis personDis);
    boolean addManager(PersonDis personDis);
    List<Person> selectAll();
    boolean saveUserNum(String userNum);
    String getUerNum();
    boolean editPerson(PersonDis personDis);
    boolean editPassword(PersonDis personDis);
    boolean deletePerson(String userNum);
    Person selectPersonByNum(String Num);
    List<Person> selectPeopleByPager(Pager<PersonDis> pager);
    PersonDis getPersonDis(Person person);
    List<PersonDis> getPeopleDis(List<Person> people);
    List<Person> selectUsersByPager(Pager<PersonDis> pager);

}

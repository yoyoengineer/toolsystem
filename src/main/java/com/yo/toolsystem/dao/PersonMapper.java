package com.yo.toolsystem.dao;

import com.yo.toolsystem.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    int deleteByPrimaryKey(String usernum);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String usernum);

    List<Person> selectAll();

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    int selectAllPersonNum();

    int selectSubManagerNum();

    int selectUsersNum();

    List<Person> selectPeopleByPager(Map<String, Object> map);

}
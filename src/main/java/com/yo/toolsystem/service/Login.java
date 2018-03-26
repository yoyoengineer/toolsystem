package com.yo.toolsystem.service;

import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonLg;

/**
 * Created by Yoy on 2017/4/22.
 */
public interface Login {
    int verify(PersonLg personLg);
    Person selectPersonByPrimaryKey(String userNum);
}

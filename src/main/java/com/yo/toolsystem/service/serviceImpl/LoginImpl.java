package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.dao.PersonMapper;
import com.yo.toolsystem.model.Person;
import com.yo.toolsystem.model.PersonLg;
import com.yo.toolsystem.service.Login;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yoy on 2017/4/22.
 */
@Service
public class LoginImpl implements Login {
    @Resource
    private PersonMapper personMapper;

    public Person selectPersonByPrimaryKey(String userNum){
        return personMapper.selectByPrimaryKey(userNum);
    }

    public int verify(PersonLg personLg) {
        Person user = personMapper.selectByPrimaryKey(personLg.getUsernum());
        if (user.getPassword().equals(personLg.getPassword())){
            return user.getCategory();
        }else{
            return 0;
        }
    }
}

package com.linpiao.webblogapplication.service.impl;

import com.linpiao.webblogapplication.mapper.BlogUsersMapper;
import com.linpiao.webblogapplication.mapper.PersonsMapper;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.Persons;
import com.linpiao.webblogapplication.service.BlogUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BlogUsersServiceA implements BlogUsersService {


    @Autowired
    private BlogUsersMapper blogUsersMapper;

    @Autowired
    private PersonsMapper personsMapper;


    @Override
    public BlogUsers getBlogUser(String userName){
       return  blogUsersMapper.getBlogUserByUserName(userName);
    }

    @Override
    public List<BlogUsers>  getBlogUserByFirstName(String firstName){
        return blogUsersMapper.getBlogUsersByFirstName(firstName);
    }

    @Override
    public void delete(BlogUsers blogUser){
        blogUsersMapper.delete(blogUser);
    }

    @Override
    public void create(BlogUsers blogUser){
        Date inputdate = blogUser.getDob();

        if (inputdate==null){
            Date date = new Date();
            blogUser.setDob(date);
        }
//        blogUser.getStatusLevel();
        // also create related person
        String userName = blogUser.getUserName();
        String firstName = blogUser.getFirstName();
        String lastName = blogUser.getLastName();

        Persons person = new Persons(userName, firstName, lastName);
        personsMapper.create(person);
        blogUsersMapper.create(blogUser);



    }

    @Override
    public void updateLastName(BlogUsers blogUsers, String newLastName){
        blogUsersMapper.updateLastName(blogUsers, newLastName);
    }
}

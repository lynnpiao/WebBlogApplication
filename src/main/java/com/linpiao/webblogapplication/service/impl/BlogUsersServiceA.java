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
        System.out.println(userName);
       return  blogUsersMapper.getBlogUserByUserName(userName);
    }

    @Override
    public List<BlogUsers>  getBlogUserByFirstName(String firstName){
        return blogUsersMapper.getBlogUsersByFirstName(firstName);
    }

    @Override
    public void delete(BlogUsers blogUsers){
        String userName = blogUsers.getUserName();
        blogUsersMapper.delete(userName);
    }

    @Override
    public void create(BlogUsers blogUser){
        String userName = blogUser.getUserName();
        Date dob = blogUser.getDob();
        BlogUsers.StatusLevel statusLevel = blogUser.getStatusLevel();
        blogUsersMapper.create(userName, dob, statusLevel);

    }

    @Override
    public void updateLastName(BlogUsers blogUsers, String newLastName){
        String userName = blogUsers.getUserName();
        blogUsersMapper.updateLastName(newLastName, userName);
    }
}

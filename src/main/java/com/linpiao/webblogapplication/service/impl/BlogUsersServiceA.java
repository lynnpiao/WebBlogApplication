package com.linpiao.webblogapplication.service.impl;

import com.linpiao.webblogapplication.mapper.BlogUsersMapper;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.service.BlogUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BlogUsersServiceA implements BlogUsersService {


    @Autowired
    private BlogUsersMapper blogUsersMapper;


    @Override
    public BlogUsers getBlogUser(String userName){
       return  blogUsersMapper.getBlogUserByUserName(userName);
    }

    @Override
    public List<BlogUsers>  getBlogUserByFirstName(String firstName){
        return blogUsersMapper.getBlogUsersByFirstName(firstName);
    }

    @Override
    public void  delete(String userName){
        blogUsersMapper.delete(userName);
    }

    @Override
    public void create(BlogUsers blogUser){
        Date date = new Date();
        blogUser.setDob(date);
        blogUsersMapper.create(blogUser);
    }


    public void updateLastName(BlogUsers blogUsers){
        blogUsersMapper.updateLastName(blogUsers);
    }
}

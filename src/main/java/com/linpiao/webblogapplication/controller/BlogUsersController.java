package com.linpiao.webblogapplication.controller;


import com.linpiao.webblogapplication.pojo.*;
import com.linpiao.webblogapplication.service.BlogUsersService;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class BlogUsersController {


    @Autowired
    private BlogUsersService blogUsersService;


    @GetMapping("/findBlogUsers")
    public Result getBlogUserByFirstName(@RequestParam String firstName){
        log.info("request blogUser info");
        List<BlogUsers> blogUsers= blogUsersService.getBlogUserByFirstName(firstName);
        return Result.success(blogUsers);
    }

    @DeleteMapping("/deleteBlogUser")
    public Result delete(@RequestParam String userName){
        BlogUsers blogUser = blogUsersService.getBlogUser(userName);
        log.info("delete the blogUser:{}", blogUser.getUserName());
        blogUsersService.delete(blogUser);
        return Result.success();

    }

    @PostMapping("/createBlogUser")
    public Result create(@RequestBody BlogUsers blogUser){
        log.info("add new BlogUser:{}", blogUser);
        blogUsersService.create(blogUser);
        return Result.success();
    }


    @PutMapping("/updateLastName")
    public Result update(@RequestParam String userName, @RequestParam String newLastName){
        BlogUsers blogUser = blogUsersService.getBlogUser(userName);
        log.info("update lastName{} using userName{}", newLastName, blogUser.getUserName());
        blogUsersService.updateLastName(blogUser, newLastName);
        return Result.success();
    }


}

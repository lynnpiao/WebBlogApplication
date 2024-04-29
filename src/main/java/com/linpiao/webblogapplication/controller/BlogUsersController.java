package com.linpiao.webblogapplication.controller;


import com.linpiao.webblogapplication.pojo.*;
import com.linpiao.webblogapplication.service.BlogUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class BlogUsersController {


    @Autowired
    private BlogUsersService blogUsersService;


    @GetMapping("/blogUsers/{userName}")
    public Result getBlogUser(@PathVariable String userName){
        log.info("request blogUser info");
        BlogUsers blogUser= blogUsersService.getBlogUser(userName);
        return Result.success(blogUser);
    }

    @GetMapping("/blogUsers/1/{firstName}")
    public Result getBlogUserByFirstName(@PathVariable String firstName){
        log.info("request blogUser info");
        List<BlogUsers> blogUsers= blogUsersService.getBlogUserByFirstName(firstName);
        return Result.success(blogUsers);
    }

    @DeleteMapping("/blogUsers/{userName}")
    public Result delete(@PathVariable String userName){
        log.info("delete the blogUser:{}", userName);
        blogUsersService.delete(userName);
        return Result.success();

    }

    @PutMapping("/blogUsers/{id}")
    public Result create(@PathVariable Long id, @RequestBody BlogUsers blogUser){
        log.info("add new BlogUser:{}", blogUser);
        blogUsersService.create(blogUser);
        return Result.success();
    }


    @PostMapping("/blogUsers")
    public Result update(@RequestBody BlogUsers blogUser){
        log.info("update lastName{} using userName{}", blogUser.getLastName(), blogUser.getUserName());
        blogUsersService.updateLastName(blogUser);
        return Result.success();
    }


}

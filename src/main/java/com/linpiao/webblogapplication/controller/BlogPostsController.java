package com.linpiao.webblogapplication.controller;

import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.Result;
import com.linpiao.webblogapplication.service.BlogPostsService;
import com.linpiao.webblogapplication.service.BlogUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class BlogPostsController {


    @Autowired
    private BlogPostsService blogPostsService;

    @Autowired
    private BlogUsersService blogUsersService;


    @GetMapping("/findBlogPosts")
    public Result getBlogPostsByBlogUser(@RequestParam String userName){
        log.info("request BlogPosts info");
        BlogUsers blogUser = blogUsersService.getBlogUser(userName);
        List<BlogPosts> blogPosts= blogPostsService.getBlogPostsByBlogUser(blogUser);
        return Result.success(blogPosts);
    }




}

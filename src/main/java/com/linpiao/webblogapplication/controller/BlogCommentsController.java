package com.linpiao.webblogapplication.controller;


import com.linpiao.webblogapplication.pojo.*;
import com.linpiao.webblogapplication.service.BlogCommentsService;
import com.linpiao.webblogapplication.service.BlogPostsService;
import com.linpiao.webblogapplication.service.BlogUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class BlogCommentsController {


    @Autowired
    private BlogCommentsService blogCommentsService;

    @Autowired
    private BlogUsersService blogUsersService;

    @Autowired
    private BlogPostsService blogPostsService;


    @GetMapping("/findBlogComments")
    public Result getBlogCommentsByBlogUserAndBlogPost(@RequestParam String userName, @RequestParam String postID){
        log.info("request BlogComments info");
        if(userName!=null && ! userName.trim().isEmpty() ){
            BlogUsers blogUser = blogUsersService.getBlogUser(userName);
            List<BlogComments> blogComments= blogCommentsService.getBlogCommentsByBlogUser(blogUser);
            return Result.success(blogComments);
        } else if (postID!= null && !postID.trim().isEmpty()) {
            Integer intPostID = Integer.parseInt(postID);
            BlogPosts blogPost = blogPostsService.getBlogPost(intPostID);
            List<BlogComments> blogComments= blogCommentsService.getBlogCommentsByBlogPost(blogPost);
            return Result.success(blogComments);
        }
    }


}

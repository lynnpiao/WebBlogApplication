package com.linpiao.webblogapplication.controller;


import com.linpiao.webblogapplication.pojo.*;
import com.linpiao.webblogapplication.service.BlogCommentsService;
import com.linpiao.webblogapplication.service.BlogPostsService;
import com.linpiao.webblogapplication.service.BlogUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
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

//    private final ObjectMapper objectMapper;
//
//    public BlogCommentsController() {
//        objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }


    @GetMapping(value = "/findBlogComments", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getBlogCommentsByBlogUserAndBlogPost(@RequestParam(required = false)  String userName,
                                                               @RequestParam(required = false)  String postID){
        log.info("request BlogComments info");
        if (userName != null && !userName.trim().isEmpty()) {
            BlogUsers blogUser = blogUsersService.getBlogUser(userName);
            if (blogUser != null) {
                List<BlogComments> blogComments = blogCommentsService.getBlogCommentsByBlogUser(blogUser);
                log.info("BlogComments: {}", blogComments);
                return ResponseEntity.ok(Result.success(blogComments));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result.error("User not found"));
            }
        } else if (postID != null && !postID.trim().isEmpty()) {
            try {
                Integer intPostID = Integer.parseInt(postID);
                BlogPosts blogPost = blogPostsService.getBlogPost(intPostID);
                if (blogPost != null) {
                    List<BlogComments> blogComments = blogCommentsService.getBlogCommentsByBlogPost(blogPost);
                    log.info("BlogComments: {}", blogComments);
                    return ResponseEntity.ok(Result.success(blogComments));
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result.error("Post not found"));
                }
            } catch (NumberFormatException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.error("Invalid postID format"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.error("Invalid parameters"));
        }
    }


    @PostMapping("/createBlogComment")
    public Result create(@RequestBody  BlogComments blogComment){
        log.info("add new BlogUser:{}", blogComment);
        if (blogComment == null || blogComment.getUserName() == null || blogComment.getPostID() == null) {
            return Result.error("Invalid BlogComment data");
        }
        String content = blogComment.getContent();
        Date created = blogComment.getCreated();
        String userName = blogComment.getUserName();
        Integer postID = blogComment.getPostID();
        blogCommentsService.createBlogComment(content, created, userName, postID);
        return Result.success();
    }




}

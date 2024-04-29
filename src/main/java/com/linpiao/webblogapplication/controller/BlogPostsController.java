package com.linpiao.webblogapplication.controller;


import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.PageBean;
import com.linpiao.webblogapplication.pojo.Result;
import com.linpiao.webblogapplication.service.BlogPostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/blogUsers/blogPosts")
public class BlogPostsController {


    @Autowired
    private BlogPostsService blogPostsService;

    @PostMapping
    public Result create(@RequestBody  BlogPosts blogPost){
        log.info("add a new Post, the title is {}", blogPost.getTitle());
        blogPostsService.create(blogPost);
        return Result.success();
    }

    @DeleteMapping("/{postID}")
    public Result delete(@PathVariable Integer postID){
        log.info("delete a old post{}", postID);
        blogPostsService.delete(postID);
        return Result.success();
    }

    @DeleteMapping("/1/{postIDs}")
    public Result deleteByList(@PathVariable List<Integer> postIDs){
        log.info("delete posts{}", postIDs);
        blogPostsService.deleteByList(postIDs);
        return Result.success();
    }



    @GetMapping("/2")
    public Result pageSelectWithParams(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                       String name, @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        log.info("display by page{}, {}, {},{}, {}", page, pageSize, name, beginDate, endDate);
        PageBean pageBean = blogPostsService.pageSelectWithParams(page, pageSize, name, beginDate, endDate);
        return  Result.success(pageBean);
    }



}

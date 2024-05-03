package com.linpiao.webblogapplication.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linpiao.webblogapplication.mapper.BlogPostsMapper;
import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.PageBean;
import com.linpiao.webblogapplication.service.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BlogPostsServiceA implements BlogPostsService {

    @Autowired
    private BlogPostsMapper blogPostsMapper;


    @Override
    public BlogPosts getBlogPost(Integer postID){
        return  blogPostsMapper.getBlogPostByPostID(postID);
    }

    @Override
    public List<BlogPosts> getBlogPostsByBlogUser(BlogUsers blogUser){
        return blogPostsMapper.getBlogPostsByBlogUser(blogUser);
    }



}

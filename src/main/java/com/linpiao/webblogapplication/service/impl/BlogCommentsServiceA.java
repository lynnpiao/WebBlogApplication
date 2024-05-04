package com.linpiao.webblogapplication.service.impl;


import com.linpiao.webblogapplication.mapper.BlogCommentsMapper;
import com.linpiao.webblogapplication.pojo.BlogComments;
import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.service.BlogCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCommentsServiceA implements BlogCommentsService {

    @Autowired
    private BlogCommentsMapper blogCommentsMapper;

    @Override
    public BlogComments getBlogCommentsByCommentID(Integer commentID){
//        System.out.println("start to retrieve blog comments by ID");
        return blogCommentsMapper.getBlogCommentByCommentID(commentID);
    }

    @Override
    public List<BlogComments> getBlogCommentsByBlogUser(BlogUsers blogUser){
//        System.out.println("start to retrieve blog comments by bloguser");
//        System.out.println(blogUser);
        return blogCommentsMapper.getBlogCommentsByBlogUser(blogUser);
    }

    @Override
    public List<BlogComments> getBlogCommentsByBlogPost(BlogPosts blogPost){
//        System.out.println("start to retrieve blog comments by blogPost");
//        System.out.println(blogPost);
        return blogCommentsMapper.getBlogCommentsByBlogPost(blogPost);
    }


}

package com.linpiao.webblogapplication.service;

import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.PageBean;

import java.util.Date;
import java.util.List;

public interface BlogPostsService {


    BlogPosts  getBlogPost(Integer postID);
//
    List<BlogPosts> getBlogPostsByBlogUser(BlogUsers blogUser);

//    PageBean pageSelectWithParams(Integer page, Integer pageSize, String name, Date beginDate, Date endDate);




}

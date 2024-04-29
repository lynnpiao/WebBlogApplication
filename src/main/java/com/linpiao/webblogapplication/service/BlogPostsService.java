package com.linpiao.webblogapplication.service;

import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.PageBean;

import java.util.Date;
import java.util.List;

public interface BlogPostsService {



    void create(BlogPosts blogPost);

    void delete(Integer postID);

    void deleteByList(List<Integer> postIDs);
    PageBean pageSelectWithParams(Integer page, Integer pageSize, String name, Date beginDate, Date endDate);




}

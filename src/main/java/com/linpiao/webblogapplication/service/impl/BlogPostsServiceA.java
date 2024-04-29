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
    public void create(BlogPosts blogPost){
        Date date = new Date();
//        BlogUsers blogUser = new BlogUsers(blogPost.getUserName());
        blogPost.setCreated(date);
//        blogPost.setBlogUsers(blogUser);
        blogPostsMapper.create(blogPost);
    }

    @Override
    public void delete(Integer postID){
        blogPostsMapper.delete(postID);
    }

    @Override
    public void deleteByList(List<Integer> postIDs){
        blogPostsMapper.deleteByPostIDLists(postIDs);
    }
    @Override
    public PageBean pageSelectWithParams(Integer page, Integer pageSize, String name, Date beginDate, Date endDate){
        PageHelper.startPage(page, pageSize);
        List<BlogPosts> bpList = blogPostsMapper.selectWithParams(name, beginDate, endDate);
        Page<BlogPosts> ps = (Page<BlogPosts>) bpList;

        PageBean pageBean = new PageBean(ps.getTotal(), ps.getResult());
        return pageBean;
    }

}

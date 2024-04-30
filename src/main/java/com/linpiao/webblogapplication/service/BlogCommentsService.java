package com.linpiao.webblogapplication.service;

import com.linpiao.webblogapplication.pojo.BlogComments;
import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;

import java.util.List;

public interface BlogCommentsService {

    List<BlogComments> getBlogCommentsByBlogUser(BlogUsers blogUser);

    List<BlogComments> getBlogCommentsByBlogPost(BlogPosts blogPost);

}

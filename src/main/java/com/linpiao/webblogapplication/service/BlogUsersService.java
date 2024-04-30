package com.linpiao.webblogapplication.service;


import com.linpiao.webblogapplication.pojo.BlogUsers;

import java.util.List;

public interface BlogUsersService {

    BlogUsers getBlogUser(String userName);

    List<BlogUsers> getBlogUserByFirstName(String firstName);

    void delete(BlogUsers blogUser);

    void updateLastName(BlogUsers blogUser, String newLastName);

    void create(BlogUsers blogUser);
}

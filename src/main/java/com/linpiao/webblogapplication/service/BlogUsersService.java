package com.linpiao.webblogapplication.service;


import com.linpiao.webblogapplication.pojo.BlogUsers;

import java.util.List;

public interface BlogUsersService {

    BlogUsers getBlogUser(String userName);
    List<BlogUsers> getBlogUserByFirstName(String firstName);

    void delete(String userName);

    void create(BlogUsers blogUser);

    void updateLastName(BlogUsers blogUser);
}

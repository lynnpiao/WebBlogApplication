package com.linpiao.webblogapplication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPosts {

    private Integer postID;
    private String title;
    private String picture;
    private String content;
    private boolean published;
    private Date created;
    private BlogUsers blogUsers;

    public BlogPosts(Integer postID) {
        this.postID = postID;
    }

    public BlogPosts(String title, String picture, String content, boolean published, Date created, BlogUsers blogUsers) {
        this.title = title;
        this.picture = picture;
        this.content = content;
        this.published = published;
        this.created = created;
        this.blogUsers = blogUsers;
    }

    public String getUserName() {
        return this.blogUsers.getUserName();

    }

    public void setUserName(String userName) {
        BlogUsers blogUser = new BlogUsers(userName);
        this.blogUsers = blogUser;

    }
}

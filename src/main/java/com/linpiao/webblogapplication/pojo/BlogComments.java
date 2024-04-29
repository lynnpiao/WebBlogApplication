package com.linpiao.webblogapplication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogComments {
    private Integer commentID;
    private String content;
    private Date created;
    private BlogUsers blogUsers;
    private BlogPosts blogPosts;

    public BlogComments(Integer commentID, String content) {
        this.commentID = commentID;
        this.content = content;
    }

    public BlogComments(String content, Date created, BlogUsers blogUsers, BlogPosts blogPosts) {
        this.content = content;
        this.created = created;
        this.blogUsers = blogUsers;
        this.blogPosts = blogPosts;
    }

    public String getUserName() {
        return this.blogUsers.getUserName();
    }

    public void setUserName(String userName) {
        BlogUsers blogUsers = new BlogUsers();
        blogUsers.setUserName(userName);
        this.blogUsers = blogUsers;
    }

    public Integer getPostID() {
        return this.blogPosts.getPostID();
    }

    public void setPostID(Integer postID) {
        BlogPosts blogPosts = new BlogPosts();
        blogPosts.setPostID(postID);
        this.blogPosts =  blogPosts;
    }
}

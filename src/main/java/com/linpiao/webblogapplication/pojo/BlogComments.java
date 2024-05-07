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

    public BlogComments(String content, Date created, BlogUsers blogUser, BlogPosts blogPost) {
        this.content = content;
        this.created = created;
        this.blogUsers = blogUser;
        this.blogPosts = blogPost;
    }

//    public BlogComments(Integer commentID) {
//        this.commentID = commentID;
//    }

    public String getUserName() {
        return this.getBlogUsers().getUserName();
    }

    public void setUserName(String userName) {
        BlogUsers blogUser = new BlogUsers(userName);
        this.blogUsers = blogUser;
    }

    public Integer getPostID() {
        return this.getBlogPosts().getPostID();
    }

    public void setPostID(Integer postID) {
        BlogPosts blogPosts = new BlogPosts();
        blogPosts.setPostID(postID);
        this.blogPosts=blogPosts;
    }
}

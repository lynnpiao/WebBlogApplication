package com.linpiao.webblogapplication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reshares {
    private Integer reshareID;
    private BlogUsers blogUsers;
    private BlogPosts blogPosts;
    private Date created;

    public Reshares(Integer reshareID) {
        this.reshareID = reshareID;
    }

    public Reshares(BlogUsers blogUsers, BlogPosts blogPosts, Date created) {
        this.blogUsers = blogUsers;
        this.blogPosts = blogPosts;
        this.created = created;
    }

    public String getUserName() {
        return this.blogUsers.getUserName();
    }

    public void setUserName(String userName) {
        BlogUsers blogUser = new BlogUsers(userName);
//        this.setBlogUsers(blogUsers);
        this.blogUsers = blogUser;
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

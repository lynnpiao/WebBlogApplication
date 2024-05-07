package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.BlogComments;
import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogCommentsMapper {

    @Insert("insert into BlogComments(Content, Created, UserName, PostId)" +
             "values(#{content}, #{created}, #{userName}, #{postID});")
    public void create(BlogComments blogComment);


    public void createByCommentLists(Map<String, List<Object>> infoMap);

    @Update("update BlogComments set Content=#{newContent} where CommentId=#{commentID}")
    public void updateContent(String newContent, Integer commentID);

    @Delete("delete from BlogComments where CommentId=#{commentID}")
    public void delete(Integer commentID);

    public void deleteByCommentLists(List<Integer> commentIDList);

    public BlogComments getBlogCommentByCommentID(Integer commentID);

    public List<BlogComments> getBlogCommentsByBlogUser(BlogUsers blogUser);

    public List<BlogComments> getBlogCommentsByBlogPost(BlogPosts blogPost);


}

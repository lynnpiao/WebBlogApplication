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
    public void updateContent(BlogComments blogComment, String newContent);

    @Delete("delete from BlogComments where CommentId=#{commentID}")
    public void delete(BlogComments blogComment);

    public void deleteByCommentLists(List<Integer> commentIDList);

//    @Select("select * from BlogComments where CommentId=#{commentID}")
    public BlogComments getBlogCommentByCommentID(Integer commentID);

//    @Select("select  CommentId, Content, Created, BlogComments.UserName,  BlogComments.PostId from " +
//            "BlogComments inner join BlogUsers " +
//            "on BlogComments.UserName=BlogUsers.UserName " +
//            "where BlogUsers.UserName= #{userName}")
    public List<BlogComments> getBlogCommentsByBlogUser(BlogUsers blogUser);

//    @Select("select CommentId, BlogComments.Content, BlogComments.Created, BlogComments.UserName, BlogComments.PostId from " +
//            "BlogComments inner join BlogPosts " +
//            "on BlogPosts.PostId=BlogComments.PostId " +
//            "where BlogPosts.PostId= #{postID}")
    public List<BlogComments> getBlogCommentsByBlogPost(BlogPosts blogPost);


}

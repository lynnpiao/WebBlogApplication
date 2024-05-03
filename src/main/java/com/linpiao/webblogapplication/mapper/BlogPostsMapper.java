package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface BlogPostsMapper {

    @Insert("insert into BlogPosts(Title, Picture, Content, Published, Created, UserName)" +
             "values(#{title}, #{picture}, #{content}, #{published}, #{created}, #{userName});")
    public void create(BlogPosts blogPost);

    public void createByPostIDLists(Map<String, List<Object>> infoMap);

    @Update("update BlogPosts set Content=#{content} where PostId=#{postID}")
    public void updateContent(String content, Integer postID);

    @Delete("delete from BlogPosts where PostId=#{postID}")
    public void delete(Integer postID);

    public void deleteByPostIDLists(List<Integer> postIDList);

    public BlogPosts getBlogPostByPostID(Integer postID);

    public List<BlogPosts> getBlogPostsByBlogUser(BlogUsers blogUser);



}

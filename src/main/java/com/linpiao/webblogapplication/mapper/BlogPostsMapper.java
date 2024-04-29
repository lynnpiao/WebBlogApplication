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
             "values(#{title}, #{picture}, #{content},#{published},#{created}, #{userName});")
    public void create(BlogPosts blogPost);

    public void createByPostIDLists(Map<String, List<Object>> infoMap);

    @Update("update BlogPosts set Content=#{content} where PostId=#{postID}")
    public void updateContent(BlogPosts blogPost);

    @Delete("delete from BlogPosts where PostId=#{postID}")
    public void delete(Integer postID);

    public void deleteByPostIDLists(List<Integer> postIDList);


    public List<BlogPosts> selectWithParams(String name, Date beginDate, Date endDate);

    @Select("select * from BlogPosts where PostId=#{postID}")
    public BlogPosts getBlogPostByPostID(Integer postID);

    @Select("select PostId, Title, Content, Published, Created, BlogPosts.UserName from " +
            "BlogPosts inner join BlogUsers on BlogPosts.UserName=BlogUsers.UserName " +
            "where BlogUsers.UserName= #{userName}")
    public List<BlogPosts> getBlogPostsByBlogUser(BlogUsers blogUser);


    @Select("select PostId, Title, Content, Published, Created, BlogPosts.UserName " +
            "from BlogPosts, BlogUsers, Persons" +
            " where BlogPosts.UserName =BlogUsers.UserName and BlogUsers.UserName=Persons.UserName " +
            "and Persons.FirstName = #{firstName}")
    public List<BlogPosts> getBlogPostsByFirstName(String firstName);

}

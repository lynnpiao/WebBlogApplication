package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.BlogUsers;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogUsersMapper {

    @Insert("insert into BlogUsers(UserName, DoB, StatusLevel)" +
             "values(#{userName}, #{dob}, #{statusLevel});")
    public void create(BlogUsers blogUser);

    public void createByNameLists(Map<String, List<Object>> infoMap);

    @Update("update Persons set LastName=#{newLastName} where UserName=#{userName}")
    public void updateLastName(BlogUsers blogUser, String newLastName);

    @Delete("delete from BlogUsers where UserName= #{userName}")
    public void delete(BlogUsers blogUser);

    public void deleteByUserNameLists(List<String> userNameList);

    @Select("select BlogUsers.UserName, FirstName, LastName, BlogUsers.DoB, BlogUsers.StatusLevel " +
            "from BlogUsers inner join Persons on BlogUsers.UserName=Persons.UserName " +
            "where BlogUsers.UserName= #{userName}")
    public BlogUsers getBlogUserByUserName(String userName);

    @Select("select BlogUsers.UserName, FirstName, LastName, BlogUsers.DoB, BlogUsers.StatusLevel from " +
            "BlogUsers inner join Persons " +
            "on BlogUsers.UserName= Persons.UserName " +
            "Where Persons.FirstName= #{firstName}")
    public List<BlogUsers> getBlogUsersByFirstName(String firstName);


}

package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.BlogUsers;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogUsersMapper {

    @Insert("insert into BlogUsers(UserName, DoB, StatusLevel)" +
             "values(#{userName}, #{dob}, #{statusLevel});")
    public void create(BlogUsers blogUsers);

    public void createByNameLists(Map<String, List<Object>> infoMap);

    @Update("update Persons set LastName=#{lastName} where UserName=#{userName}")
    public void updateLastName(BlogUsers blogUser);

    @Delete("delete from BlogUsers where UserName= #{userName}")
    public void delete(String userName);

    public void deleteByUserNameLists(List<String> userNameList);

    @Select("select * from BlogUsers where UserName= #{userName}")
    public BlogUsers getBlogUserByUserName(String userName);

    @Select("select BlogUsers.UserName, BlogUsers.DoB, BlogUsers.StatusLevel from " +
            "BlogUsers inner join Persons " +
            "on BlogUsers.UserName= Persons.UserName " +
            "Where Persons.FirstName= #{firstName}")
    public List<BlogUsers> getBlogUsersByFirstName(String firstName);


}

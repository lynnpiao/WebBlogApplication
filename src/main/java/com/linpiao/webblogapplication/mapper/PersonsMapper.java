package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.Persons;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonsMapper {

    @Insert("insert into Persons(UserName, FirstName, LastName)" +
            " values (#{userName}, #{firstName}, #{lastName})" )
    public void create(String userName, String firstName, String lastName);

    public void createByNameLists(Map<String, List<String>> nameMap);

    @Update("update Persons set LastName=#{newLastName} where UserName=#{userName}")
    public void updateLastName(String userName, String newLastName);

    @Delete("delete from Persons where UserName= #{userName}")
    public void delete(String userName);

    public void deleteByUserNameLists(List<String> userNameList);

    @Select("select * from Persons where UserName= #{userName}")
    public Persons getPersonByUserName(String userName);

    @Select("select * from Persons where FirstName= #{firstName}")
    public List<Persons> getPersonsByFirstName(String firstName);

    @Select("select count(*) from Persons")
    public Long count();

    @Select("select * from Persons limit #{start}, #{pageSize};")
    public List<Persons> page(Integer start, Integer pageSize);


}

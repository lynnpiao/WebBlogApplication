package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.Administrators;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdministratorsMapper {

    @Insert("insert into Administrators(UserName, LastLogin)" +
             "values(#{userName}, #{lastLogin});")
    public void create(Administrators administrator);

    public void createByNameLists(Map<String, List<Object>> infoMap);

    @Update("update Persons set LastName=#{newLastName} where UserName=#{userName}")
    public void updateLastName(Administrators administrator, String newLastName);

    @Delete("delete from Administrators where UserName= #{userName}")
    public void delete(Administrators administrator);

    public void deleteByUserNameLists(List<String> userNameList);

    @Select("select Administrators.UserName, FirstName, LastName, Administrators.LastLogin " +
            "from Administrators inner join Persons on Administrators.UserName=Persons.UserName " +
            "where Administrators.UserName= #{userName}")
    public Administrators getAdministratorByUserName(String userName);

    @Select("select Administrators.UserName, FirstName, LastName, Administrators.LastLogin from " +
            "Administrators inner join Persons " +
            "on Administrators.UserName=Persons.UserName " +
            "where Persons.FirstName= #{firstName}")
    public List<Administrators> getAdministratorsByFirstName(String firstName);


}

package com.linpiao.webblogapplication.service;

import com.linpiao.webblogapplication.mapper.PersonsMapper;
import com.linpiao.webblogapplication.pojo.PageBean;
import com.linpiao.webblogapplication.pojo.Persons;

import java.util.List;


public interface PersonsService {

    List<Persons> list();

    void delete(String userName);

    void create(Persons person);

    void createByStrings(String userName, String firstName, String lastName);

    PageBean page(Integer page, Integer pageSize);

}

package com.linpiao.webblogapplication.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linpiao.webblogapplication.mapper.PersonsMapper;
import com.linpiao.webblogapplication.pojo.PageBean;
import com.linpiao.webblogapplication.pojo.Persons;
import com.linpiao.webblogapplication.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceA implements PersonsService {

    @Autowired
    private PersonsMapper personsMapper;

    @Override
    public List<Persons> list(){
        return personsMapper.list();
    }

    @Override
    public PageBean page(Integer page, Integer pageSize){
        PageHelper.startPage(page, pageSize);
        List<Persons> pList = personsMapper.list();
        Page<Persons> p = (Page<Persons>) pList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

    }

    @Override
    public void delete(String userName){
        personsMapper.delete(userName);
    }

    @Override
    public void create(Persons person){
        personsMapper.create(person);
    }


    @Override
    public void createByStrings(String userName, String firstName, String lastName){
        Persons person = new Persons(userName, firstName, lastName);
        personsMapper.create(person);

    }

}

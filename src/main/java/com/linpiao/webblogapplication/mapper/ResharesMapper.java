package com.linpiao.webblogapplication.mapper;


import com.linpiao.webblogapplication.pojo.BlogComments;
import com.linpiao.webblogapplication.pojo.BlogPosts;
import com.linpiao.webblogapplication.pojo.BlogUsers;
import com.linpiao.webblogapplication.pojo.Reshares;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResharesMapper {

    @Insert("insert into Reshares(Created, UserName, PostId)" +
             "values(#{created}, #{userName}, #{postID});")
    public void create(Reshares reshare);

    public void createByReshareLists(Map<String, List<Object>> infoMap);


    @Delete("delete from Reshares where ReshareId=#{reshareID}")
    public void delete(Integer reshareID);

    public void deleteByReshareLists(List<Integer> reshareIDList);


    public Reshares getReshareByReshareID(Integer reshareID);

    public List<Reshares> getBlogResharesByBlogUser(BlogUsers blogUser);


}

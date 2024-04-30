package com.linpiao.webblogapplication;

import com.linpiao.webblogapplication.mapper.*;
import com.linpiao.webblogapplication.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class WebBlogApplicationTests {

    @Autowired
    private PersonsMapper personsMapper;

    @Autowired
    private AdministratorsMapper administratorsMapper;

    @Autowired
    private BlogUsersMapper blogUsersMapper;

    @Autowired
    private BlogPostsMapper blogPostsMapper;

    @Autowired
    private BlogCommentsMapper blogCommentsMapper;

    @Autowired
    private ResharesMapper resharesMapper;


    // Persons related create DAO tests
    @Test
    public void testCreatePerson(){
        Persons person = new Persons();
        person.setUserName("JohnSmith");
        person.setFirstName("John");
        person.setLastName("Smith");

        personsMapper.create(person);

    }

    @Test
    public void testCreateByNameList(){
        List<String> list1 = List.of("JamesJohn", "PeterJohn", "PeterTaylor", "JennyTaylor", "JennyJohn", "JennySmith", "JimmyTaylor", "PeterJames", "WilliamSmith", "PeterDavis");
        List<String> list2 = List.of("James", "Peter", "Peter", "Jenny", "Jenny", "Jenny","Jimmy", "Peter", "William", "Peter");
        List<String> list3 = List.of("John", "John", "Taylor", "Taylor","John","Smith", "Taylor", "James", "Smith", "Davis");

        Map<String, List<String>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);

        personsMapper.createByNameLists(map);
    }

    // Administrators related create DAO tests
    @Test
    public void testCreateAdministrator() {
        Administrators administrator = new Administrators();
        Date date = new Date();
        Persons person = personsMapper.getPersonByUserName("WilliamSmith");
//        String userName = person.getUserName();
//        System.out.println(userName);
        administrator.setUserName(person.getUserName());
        administrator.setFirstName(person.getFirstName());
        administrator.setLastName(person.getLastName());
        administrator.setLastLogin(date);
        administratorsMapper.create(administrator);

    }

    @Test
    public void testCreateAdministratorsByNameList() {
        Date date = new Date();
//        List<Persons>  personList = personsMapper.getPersonsByFirstName("Jenny");
        List<Object> list1 = List.of("JennyTaylor", "JennyJohn", "JennySmith");
        List<Object> list2 = List.of(date, date, date);

        Map<String, List<Object>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);

        administratorsMapper.createByNameLists(map);

    }


    // BlogUsers related create DAO tests
    @Test
    public void testCreateBlogUser(){
        Persons person = personsMapper.getPersonByUserName("JennyTaylor");
        BlogUsers blogUser = new BlogUsers();
        Date date = new Date();
//        String userName = person.getUserName();
        blogUser.setUserName(person.getUserName());
        blogUser.setFirstName(person.getFirstName());
        blogUser.setLastName(person.getLastName());
        blogUser.setDob(date);
        blogUser.setStatusLevel(BlogUsers.StatusLevel.novice);

        blogUsersMapper.create(blogUser);

    }

    @Test
    public void testCreateBlogUsersByNameList(){
        Date date = new Date();
        List<Object> list1 = List.of("JennyJohn", "JennySmith", "JimmyTaylor", "PeterJames", "PeterDavis");
        List<Object> list2 = List.of(date, date, date, date, date);
        List<Object> list3 = List.of(BlogUsers.StatusLevel.novice, BlogUsers.StatusLevel.novice, BlogUsers.StatusLevel.intermediate, BlogUsers.StatusLevel.intermediate, BlogUsers.StatusLevel.advanced);

        Map<String, List<Object>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);

        blogUsersMapper.createByNameLists(map);

    }

    // BlogPosts related create DAO tests
    @Test
    public void testCreateBlogPost(){
        BlogPosts blogPost = new BlogPosts();
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
        Date date = new Date();
        blogPost.setTitle("HandCream");
        blogPost.setPicture("BurtsBees");
        blogPost.setContent("Honey&GRAPESEED");
        blogPost.setCreated(date);
        blogPost.setPublished(false);
        blogPost.setBlogUsers(blogUser);

        blogPostsMapper.create(blogPost);

    }

    @Test
    public void testCreateBlogPostsByList(){
        Date date = new Date();
        List<Object> list1 = List.of("YummyFood", "HowToLearnEnglishFast", "GoodItem", "SpringComing");
        List<Object> list2 = List.of("noodle", "english", "black", "sunny");
        List<Object> list3 = List.of("food", "book", "sunglasses", "weather");
        List<Object> list4 = List.of(false, true, false, false);
        List<Object> list5 = List.of(date, date, date, date);
//        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
//        BlogUsers blogUser1 = blogUsersMapper.getBlogUserByUserName("PeterJames");
        List<Object> list6 = List.of("PeterDavis", "PeterDavis", "PeterJames", "PeterJames");

        Map<String, List<Object>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);
        map.put("list4", list4);
        map.put("list5", list5);
        map.put("list6", list6);

        blogPostsMapper.createByPostIDLists(map);

    }



    // BlogComments related create DAO tests
    @Test
    public void testCreateBlogComments(){
        BlogComments blogComment = new BlogComments();
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(5);
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("JimmyTaylor");
        Date date = new Date();
        blogComment.setContent("Nice");
        blogComment.setCreated(date);
        blogComment.setBlogUsers(blogUser);
        blogComment.setBlogPosts(blogPost);

        blogCommentsMapper.create(blogComment);

    }

    @Test
    public void testCreateBlogCommentsByList(){
        Date date = new Date();
        List<Object> list1 = List.of("GoodRecommend", "Yummy", "NicePlace");
        List<Object> list2 = List.of(date, date, date);
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("JimmyTaylor");
        List<Object> list3 = List.of(blogUser.getUserName(), blogUser.getUserName(), blogUser.getUserName());
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(4);
        List<Object> list4 = List.of(blogPost.getPostID(), blogPost.getPostID(), blogPost.getPostID());


        Map<String, List<Object>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);
        map.put("list4", list4);


        blogCommentsMapper.createByCommentLists(map);

    }

    // Reshares related create DAO tests
    @Test
    public void testCreateReshares(){
        Reshares reshares = new Reshares();
        Date date = new Date();
        reshares.setCreated(date);
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(5);
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
        reshares.setBlogUsers(blogUser);
        reshares.setBlogPosts(blogPost);
        resharesMapper.create(reshares);

    }

    @Test
    public void testCreateResharesByList(){
        Date date = new Date();
        List<Object> list1 = List.of(date, date, date);
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
        BlogUsers blogUser1 = blogUsersMapper.getBlogUserByUserName("PeterJames");
        BlogUsers blogUser2 = blogUsersMapper.getBlogUserByUserName("JimmyTaylor");
        List<Object> list2 = List.of(blogUser.getUserName(), blogUser1.getUserName(), blogUser2.getUserName());
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(5);
        List<Object> list3 = List.of(blogPost.getPostID(), blogPost.getPostID(), blogPost.getPostID());


        Map<String, List<Object>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        map.put("list3", list3);


        resharesMapper.createByReshareLists(map);

    }


    @Test
    public void testUpdatePersonLastName(){
        Persons person = new Persons();
        person.setUserName("JohnSmith");
//        person.setLastName("William");

        personsMapper.updateLastName(person, "William");
    }


//    @Test
//    public void testDeletePerson(){
//        personsMapper.delete("JohnSmith");
//    }

    @Test
    public void testDeleteByUserNameList(){
        List<String> userNameList = List.of("JamesJohn", "PeterJohn");
        personsMapper.deleteByUserNameLists(userNameList);
    }


    @Test
    public void testGetPersonByUserName() {
        Persons person = personsMapper.getPersonByUserName("PeterTaylor");
        System.out.println(person);
    }


    @Test
    public void testGetPersonsByFirstName() throws InterruptedException {
        List<Persons>  personList = personsMapper.getPersonsByFirstName("Jenny");
        personList.stream().forEach(persons -> {System.out.println(persons);});

//        addDelay();

    }


    @Test
    public void testGetAdministratorByUserName() {
        Administrators administrator = administratorsMapper.getAdministratorByUserName("JennySmith");
        System.out.println(administrator);
    }

    @Test
    public void testGetAdministratorsByFirstName() {
        List<Administrators> administratorsList = administratorsMapper.getAdministratorsByFirstName("Jenny");
        administratorsList.stream().forEach(administrator -> {
            System.out.println(administrator);
        });

    }


    @Test
    public void testGetBlogUserByUserName() {
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterJames");
        System.out.println(blogUser);
    }

    @Test
    public void testGetBlogUsersByFirstName(){
        List<BlogUsers>  blogUsersList = blogUsersMapper.getBlogUsersByFirstName("Peter");
        blogUsersList.stream().forEach(blogUser -> {System.out.println(blogUser);});

    }


    @Test
    public void testGetBlogPostByPostID() {
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(4);
        System.out.println(blogPost);
    }

    @Test
    public void testGetBlogPostsByBlogUser(){
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
        List<BlogPosts>  blogPostsList = blogPostsMapper.getBlogPostsByBlogUser(blogUser);
        blogPostsList.stream().forEach(blogPost -> {System.out.println(blogPost);});

    }

    @Test
    public void testGetBlogPostsByFirstName(){
        String firstName="Peter";
        List<BlogPosts>  blogPostsList = blogPostsMapper.getBlogPostsByFirstName(firstName);
        blogPostsList.stream().forEach(blogPost -> {System.out.println(blogPost);});
    }


    @Test
    public void testGetBlogCommentByCommentID() {
        BlogComments blogComment = blogCommentsMapper.getBlogCommentByCommentID(1);
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(blogComment.getPostID());
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName(blogComment.getUserName());
        System.out.println(blogComment);
        System.out.println(blogUser);
        System.out.println(blogPost);
    }

    @Test
    public void testGetBlogCommentsByBlogUser(){
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("JimmyTaylor");
        List<BlogComments>  blogCommentsList = blogCommentsMapper.getBlogCommentsByBlogUser(blogUser);
        blogCommentsList.stream().forEach(blogComment -> {System.out.println(blogComment);});

    }

    @Test
    public void testGetBlogCommentsByBlogPost(){
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(4);
        List<BlogComments>  blogCommentsList = blogCommentsMapper.getBlogCommentsByBlogPost(blogPost);
        blogCommentsList.stream().forEach(blogComment -> {System.out.println(blogComment);});

    }


    @Test
    public void testGetReshareByReshareID() {
        Reshares reshares = resharesMapper.getReshareByReshareID(4);
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName(reshares.getUserName());
        BlogPosts blogPost = blogPostsMapper.getBlogPostByPostID(reshares.getPostID());
        System.out.println(reshares);
        System.out.println(blogUser);
        System.out.println(blogPost);
    }

    @Test
    public void testGetReshareByBlogUser(){
        BlogUsers blogUser = blogUsersMapper.getBlogUserByUserName("PeterDavis");
        List<Reshares>  reshareList = resharesMapper.getBlogResharesByBlogUser(blogUser);
        reshareList.stream().forEach(reshare -> {System.out.println(reshare);});

    }


    private void addDelay() throws InterruptedException {
        Thread.sleep(5000); // Add a delay of 2 seconds (2000 milliseconds)
        System.out.println("Delay Execute");
    }

}

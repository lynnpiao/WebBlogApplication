package com.linpiao.webblogapplication.controller;

import com.linpiao.webblogapplication.pojo.PageBean;
import com.linpiao.webblogapplication.pojo.Persons;
import com.linpiao.webblogapplication.pojo.Result;
import com.linpiao.webblogapplication.service.PersonsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
//@RequestMapping("/persons")
public class PersonsController{

    @Autowired
    private PersonsService personsService;

//    private static Logger log= LoggerFactory.getLogger(PersonsController.class);
    @GetMapping("/persons")
    public Result list(){
        log.info("request person info");
        List<Persons> personList = personsService.list();
        return Result.success(personList);
    }

    @GetMapping("/persons/1")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("display by page{}, {}", page, pageSize);
        PageBean pageBean = personsService.page(page, pageSize);
        return  Result.success(pageBean);
    }


    @DeleteMapping("/persons/{userName}")
    public Result delete(@PathVariable String userName) {
        log.info("deleting Person by userName:{}", userName);
        personsService.delete(userName);
        return Result.success();
    }

    @PostMapping("/persons")
    public Result create(@RequestBody Persons person){
        log.info("adding Person:{}", person);
        personsService.create(person);
        return Result.success();

    }

    @PostMapping("/upload")
    public Result upload(String userName, String firstName, String lastName, MultipartFile image) throws Exception{
        log.info("upload, {}, {}, {}, {}:", userName, firstName, lastName, image);
        String Filename = image.getOriginalFilename();
        int  index = Filename.lastIndexOf(".");
        String lastFilename = Filename.substring(index);
        String newFilename = UUID.randomUUID().toString() + lastFilename;
        image.transferTo(new File("/Users/linpiao/uploadfile/"+newFilename));
        personsService.createByStrings(userName, firstName, lastName);
        return Result.success();
    }


}

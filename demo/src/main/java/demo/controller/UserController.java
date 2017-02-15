package demo.controller;

import demo.domain.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by new on 17-2-15.
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    UserService service;
    //通过 Get 方法访问 localhost:8888/test/sunlian 可查询 sunlian 在database中的信息
    @RequestMapping(value = "/{name}" , method = RequestMethod.GET)
    public User query(@PathVariable String name){
        return service.query(name);
    }

    //通过 POST 方法访问 localhost:8888/test 向database添加数据
    @RequestMapping(value = "" , method = RequestMethod.POST)
    public String upload(String name, Integer age){
        return service.upload(name,age);
    }

    //通过 PUT 方法访问 localhost:8888/test 向database更新数据
    @RequestMapping(value = "" , method = RequestMethod.PUT)
    public void update( String name, Integer age){
        service.update(name,age);
    }

    //通过 DELETE 方法访问 localhost:8888/test/0 向database删除数据id为0的数据
    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

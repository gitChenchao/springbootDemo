package com.cc.cloud.controller;

import com.cc.cloud.entity.User;
import com.cc.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2018年04月28日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@RestController
@Slf4j
public class UserController {

    /**
     * 疑问1 TODO ribbon 如何修改负载规则
     */
    private UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") String id){
        LOGGER.info("访问接口: /getUser/"+id);
        return userService.findOne(id);
    }
    @PostMapping("/saveUser")
    public Object save(){
        User user = new User();
        user.setId("2");
        user.setName("chenchao");
        user.setAge("28");
        userService.save(user);
        return "true";
    }
    @GetMapping("/getListUser")
    public List<User> getListUser(){
        return userService.getListUser();
    }
}

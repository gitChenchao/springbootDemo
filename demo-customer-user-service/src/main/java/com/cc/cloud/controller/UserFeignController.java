package com.cc.cloud.controller;

import com.cc.cloud.entity.User;
import com.cc.cloud.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：UserFeignController<br>
 * 类描述：<br>
 * 创建时间：2018年04月30日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@RestController
@Slf4j
public class UserFeignController {

    private UserFeignClient userFeignClient;

    public UserFeignController(UserFeignClient userFeignClient){
        this.userFeignClient=userFeignClient;
    }

    @GetMapping("/fegin/user/get/{id}")
    public User get(@PathVariable("id") String id){
        return userFeignClient.findOne(id);
    }

    @HystrixCommand(fallbackMethod = "userListFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "50000"),//在调用方配置，被该调用方的所有方法的超时时间都是该值
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000")},//制定多久超时.超时进fallback 单位毫秒 10s
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "1"),//线程池大小
                    @HystrixProperty(name="maxQueueSize",value = "20")})//-1表示不等待直接拒绝
    @GetMapping("/feign/userList")
    public List<User> getListUser(){
        return userFeignClient.getListUser();
    }

    public List<User> userListFallback(){
        List<User> list = new ArrayList<User>();
        User u = new User();
        u.setId("99");
        u.setAge("99");
        u.setName("HystrixTest");
        list.add(u);
        return list;
    }
}

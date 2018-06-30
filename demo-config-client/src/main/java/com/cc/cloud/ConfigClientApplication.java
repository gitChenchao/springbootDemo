package com.cc.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：ConfigClientApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
@RefreshScope//配置手动刷新/refresh
public class ConfigClientApplication {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientApplication.class,args);
        //TODO 疑问如何坐到不手动刷新达到自动更新配置文件 手动刷新是通过什么传输的?
    }

    @Value("${name}")
    String name;

    @Value("${age}")
    String age;

    @Value("${version}")
    String version;

    @RequestMapping("/hello")
    public String hello(){
        return "你好，我是"+name+" ,我今年"+age+"岁，这是"+version;
    }
}

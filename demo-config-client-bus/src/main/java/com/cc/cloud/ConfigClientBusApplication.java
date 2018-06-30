package com.cc.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：ConfigClientBusApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月04日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
@RefreshScope//配置手动刷新/refresh
public class ConfigClientBusApplication {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientBusApplication.class,args);
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

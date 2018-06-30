package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类名称：ConfigServiceApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月02日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ConfigServiceApplication.class);
    }
}

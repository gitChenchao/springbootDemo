package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类名称：StreamServerApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月08日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */

//@EnableCircuitBreaker 启动断路器
//@EnableDiscoveryClient 如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
@SpringBootApplication
public class StreamServerApplication {

    public static void main(String[] args){
        SpringApplication.run(StreamServerApplication.class,args);
    }
}

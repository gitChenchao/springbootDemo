package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 类名称：CustomerUserServiceApplication<br>
 * 类描述：<br>
 * 创建时间：2018年04月30日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients //启动feign客户端
@EnableCircuitBreaker //启动断路器支持
public class CustomerUserServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerUserServiceApplication.class);
    }
}

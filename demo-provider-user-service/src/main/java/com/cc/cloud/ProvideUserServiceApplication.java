package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类名称：ProvideUserServiceApplication<br>
 * 类描述：<br>
 * 创建时间：2018年04月28日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
//使用jpa和lombok都会自动注入数据库连接  如果不配置数据库连接的话需要加上注解exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
public class ProvideUserServiceApplication {
    public static void main(String[] arge){
        SpringApplication.run(ProvideUserServiceApplication.class);
    }
}

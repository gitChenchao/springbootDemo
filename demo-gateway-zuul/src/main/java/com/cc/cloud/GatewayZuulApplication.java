package com.cc.cloud;

import com.cc.cloud.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 类名称：GatewayZuulApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringCloudApplication
@EnableZuulProxy
public class GatewayZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(GatewayZuulApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}

package com.cc.cloud.controller;

import com.cc.cloud.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2018年04月30日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/get/{id}")
    public User get(@PathVariable Long id){

        return this.restTemplate.getForObject("http://PROVIDE-USER-SERVICE/getUser/{1}",User.class,id);
    }

    /**
     * ribbon负载均衡测试方法
     */
    @GetMapping("/log-user-service-instance")
    public void logUserServiceInstance(){
        // TODO 如何修改服务为随机访问
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("provide-user-service");

        LOGGER.info("serviceInstance info ---> serviceId is  "+serviceInstance.getServiceId()+" host is "+serviceInstance.getHost()+"port is "+serviceInstance.getPort() );
    }
}

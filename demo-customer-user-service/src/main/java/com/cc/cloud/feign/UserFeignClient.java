package com.cc.cloud.feign;

import com.cc.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 类名称：UserFeignClient<br>
 * 类描述：<br>
 * 创建时间：2018年04月30日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@FeignClient("PROVIDE-USER-SERVICE")
public interface UserFeignClient {
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    User findOne(@PathVariable("id") String id);
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    void save(User user);
    @RequestMapping(value = "/getListUser",method = RequestMethod.GET)
    List<User> getListUser();
}

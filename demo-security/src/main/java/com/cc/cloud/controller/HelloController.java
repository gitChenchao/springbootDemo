package com.cc.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：HelloController<br>
 * 类描述：<br>
 * 创建时间：2018年05月12日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

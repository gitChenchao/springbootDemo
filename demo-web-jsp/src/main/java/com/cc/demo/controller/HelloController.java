package com.cc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类名称：HelloController<br>
 * 类描述：<br>
 * 创建时间：2018年12月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Controller
@RequestMapping("/views")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}

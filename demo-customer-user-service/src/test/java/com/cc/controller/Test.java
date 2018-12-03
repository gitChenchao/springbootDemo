package com.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 类名称：Test<br>
 * 类描述：<br>
 * 创建时间：2018年09月28日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    @org.junit.Test
    public void test(){
        String url =  "http://localhost:9996/provide-user-service/saveUser/4";
        MultiValueMap<String, Object> params= new LinkedMultiValueMap<String, Object>();
        params.add("id","5");
        params.add("id","5");
        params.add("name","chenchao");
        params.add("age","29");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url,request,String.class);
        System.out.println(response);
    }
}

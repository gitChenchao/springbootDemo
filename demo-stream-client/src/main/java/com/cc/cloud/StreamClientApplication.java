package com.cc.cloud;

import com.cc.cloud.bo.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * 类名称：StreamClientApplication<br>
 * 类描述：<br>
 * 创建时间：2018年05月05日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamClientApplication {
    private static Logger logger = LoggerFactory.getLogger(StreamClientApplication.class);

    public static void main(String[] args){
        SpringApplication.run(StreamClientApplication.class,args);
    }

    @StreamListener(Sink.INPUT)
    public void input(Message<Company> message){
        logger.info("一般监听收到：" + message.getPayload());
    }
}

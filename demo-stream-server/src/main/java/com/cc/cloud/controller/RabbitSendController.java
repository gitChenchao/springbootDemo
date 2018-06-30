package com.cc.cloud.controller;

import com.cc.cloud.enums.ExchangeEnum;
import com.cc.cloud.enums.QueueEnum;
import com.cc.cloud.service.IMessageProvider;
import com.cc.cloud.service.QueueMessageService;
import com.cc.cloud.vo.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：RabbitSend<br>
 * 类描述：<br>
 * 创建时间：2018年05月08日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@RestController
public class RabbitSendController {

    private IMessageProvider messageProvider;
    private QueueMessageService queueMessageService;

    public RabbitSendController(IMessageProvider messageProvider,QueueMessageService queueMessageService){
        this.messageProvider=messageProvider;
        this.queueMessageService=queueMessageService;
    }

    @GetMapping("/sendPO")
    public String send(){
        Company company = new Company();
        company.setCompanyName("测试公司");
        company.setCompanyAdress("测试公司地址");
        messageProvider.send(company);
        return "ok";
    }

    @GetMapping("/direct")
    public String sendDirect(){
        try{
            queueMessageService.send("hello world",ExchangeEnum.USER_REGISTER,QueueEnum.USER_REGISTER);
        }catch (Exception e){

        }
        return "ok";
    }
}

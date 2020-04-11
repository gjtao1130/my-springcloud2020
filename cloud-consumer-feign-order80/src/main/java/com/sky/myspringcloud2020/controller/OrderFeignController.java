package com.sky.myspringcloud2020.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sky.cloud2020.entity.CommonResult;
import com.sky.myspringcloud2020.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Default_FalllBack")
//@DefaultProperties没有指定fallbackMethod的默认事宜异常处理paymentInfo_Default_FalllBack方法
public class OrderFeignController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/consumerfeign/payment/getAll")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut", commandProperties = {
            @HystrixProperty(name = "excution.isolation.tread.timeoutInMilliseconds",value = "3000")})
    //@HystrixCommand放在服务提供端和消费端都可以实现服务降级处理
    public CommonResult getAll(){
        return this.paymentService.getAll();
    }

    public String paymentInfo_TimeOut(){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut ";
    }

    public String paymentInfo_Default_FalllBack(){
        return "paymentInfo_Default_FalllBack,异常。。。";
    }
}

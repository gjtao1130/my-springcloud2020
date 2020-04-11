package com.sky.myspringcloud2020.controller;

import com.sky.cloud2020.entity.CommonResult;
import com.sky.cloud2020.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //单机
    //public static final String PAYMENT_URL="http://localhost:8001";
    //使用注册中心已经注册的服务
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/comnumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return this.restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }

    @PostMapping("consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        //return this.restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return this.restTemplate.postForObject(PAYMENT_URL+"/payment/get/"+id,id,CommonResult.class);
    }

    @PostMapping("consumer/payment/getAll")
    public CommonResult getPaymentAll(){
        //return this.restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return this.restTemplate.postForObject(PAYMENT_URL+"/payment/getAll",null,CommonResult.class);
    }
}

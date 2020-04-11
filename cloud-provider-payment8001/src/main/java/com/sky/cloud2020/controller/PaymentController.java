package com.sky.cloud2020.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sky.cloud2020.entity.CommonResult;
import com.sky.cloud2020.entity.Payment;
import com.sky.cloud2020.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=this.paymentService.create(payment);
        log.info("serverPort:"+serverPort+" 插入结果："+result);

        if (result>0){
            //return new CommonResult(200,"insert SUCCESS", payment);
            return CommonResult.buildSuccess(payment);
        }
        else {
            //return new CommonResult(-1,"insert FAILT", payment);
            return CommonResult.buildFailure(payment);
        }
    }

    @PostMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment=this.paymentService.getPaymentById(id);
        log.info("serverPort:"+serverPort+" get："+payment+" serverPort:"+serverPort);

        if (payment!=null){
            //return new CommonResult(200,"search SUCCESS", payment);
            return CommonResult.buildSuccess(payment);
        }
        else {
            //return new CommonResult(-1,"search FAILT,无记录id="+id, null);
            return CommonResult.buildFailure("无记录id="+id);
        }
    }

    @PostMapping("/payment/getAll")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut", commandProperties = {
            @HystrixProperty(name = "excution.isolation.tread.timeoutInMilliseconds",value = "3000")})
    //超时访问，降级
    public CommonResult getAll(){
        List<Payment> paymentList=this.paymentService.getPaymentAll();
        log.info("serverPort:"+serverPort+" getAll："+paymentList+" serverPort:"+serverPort);

        if (paymentList!=null){
            //return new CommonResult(200,"search SUCCESS", paymentList);
            return CommonResult.buildSuccess(paymentList);
        }
        else {
            //return new CommonResult(-1,"search FAILT,无记录", null);
            return CommonResult.buildFailure("无记录");
        }
    }

    public String paymentInfo_TimeOut(){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut ";
    }

    //服务发现
    @PostMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        log.info(services.toString());
//        for (String element:services){
//            log.info(element.toString());
//        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return  this.discoveryClient;
    }
}

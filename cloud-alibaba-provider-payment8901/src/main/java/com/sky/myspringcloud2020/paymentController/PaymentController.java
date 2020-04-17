package com.sky.myspringcloud2020.paymentController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") String id){
        return "nacos registry, serverport: "+serverPort+" id: "+id;
    }
}

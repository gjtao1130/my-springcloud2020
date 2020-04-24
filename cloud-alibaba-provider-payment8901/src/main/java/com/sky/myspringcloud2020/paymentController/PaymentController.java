package com.sky.myspringcloud2020.paymentController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<String, Object> map=new HashMap<String, Object>();
    static {
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
    }

    @GetMapping(value = "payment/get/{id}")
    public String getPaymentInfo(@PathVariable("id") String id){
        return "nacos registry, serverport: "+serverPort+" id: "+id+":"+map.get(id).toString();
    }
}

package com.sky.myspringcloud2020.contoller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    //nacos
    @GetMapping(value = "/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL+"/payment/get/"+id, String.class);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //sentinel
    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/consumer/payment/sentinelget/{id}")
    @SentinelResource(value = "getSentinelInfo", blockHandler = "handleFlowQpsEception",
            fallback = "getSentinelInfoFallback")
    public String getSentinelInfo(@PathVariable("id") String id){
        //int i=1/0;
        String str=restTemplate.getForObject(serverURL+"/payment/get/"+id, String.class);
        return str;
    }

    //限流或降级时的处理逻辑
    //方法参数、返回值要与原函数保持一致
    public String handleFlowQpsEception(String id, BlockException e){
        e.printStackTrace();
        return "handleFlowQpsEception: "+ id;
    }

    //getSentinelInfo抛出的异常提供fallback处理
    //注意: 方法参数、返回值要与原函数保持一致
    public String getSentinelInfoFallback(String id, Throwable e) {
        e.printStackTrace();
        return "fallback getSentinelInfo: id" + id+"\r\n"+" MSG："+e.toString() ;
    }
}

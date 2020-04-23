package com.sky.myspringcloud2020.sentinelController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/sentinel/info")
    @SentinelResource(value = "getSentinelInfo", blockHandler = "handleFlowQpsEception",
        fallback = "getSentinelInfoFallback")
    public String getSentinelInfo(String id){
        return "sentinel: appName: "+appName +" port: "+port+ " id:"+id;
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
        return "fallback getSentinelInfo: " + id;
    }
}

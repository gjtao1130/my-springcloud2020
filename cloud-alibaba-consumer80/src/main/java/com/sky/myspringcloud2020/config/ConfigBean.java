package com.sky.myspringcloud2020.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    //使用@LoadBalanced注解赋予RestTempate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

package com.sky.myspringcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConsumer80Application.class, args);
    }

}

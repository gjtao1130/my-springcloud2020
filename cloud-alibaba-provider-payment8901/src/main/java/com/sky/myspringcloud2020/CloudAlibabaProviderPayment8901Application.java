package com.sky.myspringcloud2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment8901Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment8901Application.class, args);
    }

}

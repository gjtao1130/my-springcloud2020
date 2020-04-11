package com.sky.myspringcloud2020.service;

import com.sky.cloud2020.entity.CommonResult;
import com.sky.cloud2020.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @PostMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);

    @PostMapping("/payment/getAll")
    public CommonResult getAll();
}

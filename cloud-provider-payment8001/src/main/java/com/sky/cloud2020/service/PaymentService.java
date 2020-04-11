package com.sky.cloud2020.service;

import com.sky.cloud2020.entity.Payment;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);
    public int updatePaymentById(Long id);
    public int deletePaymentById(Long id);
    public Payment getPaymentById(Long id);
    public List<Payment> getPaymentAll();
}

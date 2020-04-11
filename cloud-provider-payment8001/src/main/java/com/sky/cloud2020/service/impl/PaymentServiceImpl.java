package com.sky.cloud2020.service.impl;

import com.sky.cloud2020.entity.Payment;
import com.sky.cloud2020.mapper.PaymentMapper;
import com.sky.cloud2020.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return this.paymentMapper.create(payment);
    }

    @Override
    public int updatePaymentById(Long id) {
        return this.paymentMapper.updatePaymentById(id);
    }

    @Override
    public int deletePaymentById(Long id) {
        return this.paymentMapper.deletePaymentById(id);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentMapper.getPaymentById(id);
    }

    @Override
    public List<Payment> getPaymentAll() {
        return this.paymentMapper.getPaymentAll();
    }
}

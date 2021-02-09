package com.tmetal.springcloud.service.impl;

import com.tmetal.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "full bal PaymentHystrixServiceImpl ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "full bal PaymentHystrixServiceImpl timeout";

    }
}

package com.tmetal.service;

import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<ProviderPay> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService",
                new ProviderPay(id, "errorSerial"));
    }
}



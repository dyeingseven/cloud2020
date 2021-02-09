package com.tmetal.springcloud.service;

import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/providerpay/get/{id}")
    public CommonResult<ProviderPay> getPaymentId(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() ;
}

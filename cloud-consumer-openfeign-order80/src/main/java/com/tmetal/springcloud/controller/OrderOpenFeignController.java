package com.tmetal.springcloud.controller;


import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import com.tmetal.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderOpenFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<ProviderPay> getPaymentById(@PathVariable("id") Long id) {

        System.out.println("openfeign*****************************************************1");

        return paymentFeignService.getPaymentId(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public  String consumerFeignTimeout(){
       return paymentFeignService.paymentFeignTimeout();
    }
}

package com.tmetal.controller;

import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, ProviderPay> hashMap = new HashMap<>();

    static {

        hashMap.put(1L, new ProviderPay(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new ProviderPay(2L, "bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L, new ProviderPay(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<ProviderPay> paymentSQL(@PathVariable("id") Long id) {
        ProviderPay providerPay = hashMap.get(id);
        CommonResult<ProviderPay> result =
                new CommonResult(200, "from mysql,serverPort:  " + serverPort, providerPay);
        return result;
    }
}

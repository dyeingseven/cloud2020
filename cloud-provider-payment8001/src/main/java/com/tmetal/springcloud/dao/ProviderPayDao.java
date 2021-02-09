package com.tmetal.springcloud.dao;

import com.tmetal.springcloud.entities.ProviderPay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProviderPayDao {


    int create(ProviderPay providerPay);

    ProviderPay getProviderPayById(@Param("id") Long id);
}


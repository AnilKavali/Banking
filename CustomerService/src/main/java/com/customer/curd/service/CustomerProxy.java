package com.customer.curd.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.customer.curd.model.CustomerAccounts;

@FeignClient(name="MANAGER-SERVICE", url="http://localhost:9899/")
public interface CustomerProxy {
    @GetMapping("/custInfo")
    public List<CustomerAccounts> CustomerInfo();

}

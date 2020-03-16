package com.sgcc.pms.mricroservicegoods.service.servicecalls.baseutils;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "microservice-framworkutils",
        fallbackFactory = BaseUtilsFallBackFactory.class)
@Service
@RequestMapping("/base/util")
public interface BaseUtils {
    @GetMapping("/time")
    public String getTime();
}

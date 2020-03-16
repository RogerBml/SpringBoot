package com.sgcc.jxd.microservicegoodsnacos.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping
@RestController
public class GoodsController {

   // @Value("${company.info}")
    private String configInfo ="1111";

    @GetMapping("/nocos")
    public String getConfig() {
        return configInfo;
    }
}

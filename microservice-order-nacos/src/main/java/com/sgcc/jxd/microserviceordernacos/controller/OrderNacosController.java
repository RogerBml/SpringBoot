package com.sgcc.jxd.microserviceordernacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordernacos")
public class OrderNacosController {

    @GetMapping("/nacos")
    public String testNacos(){
        return "ordernacos";
    }
    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey",blockHandler = "del_testhitkey")
    public String testhotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "testhotkey";
    }

    public String del_testhitkey(String p1, String p2, BlockException block){
        return "testhotkey exception";
    }

}

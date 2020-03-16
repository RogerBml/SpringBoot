package com.sgcc.jxd.microservicelogin.controller;

import com.sgcc.jxd.microservicelogin.bean.RolerRight;
import com.sgcc.jxd.microservicelogin.service.RolerRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RolerRight")
@RefreshScope
public class RolerRightController {
    @Autowired
    private RolerRightService rolerRightService;

    @GetMapping("/list")
    public List<RolerRight> listRights(){
        return rolerRightService.listRight();
    }
}

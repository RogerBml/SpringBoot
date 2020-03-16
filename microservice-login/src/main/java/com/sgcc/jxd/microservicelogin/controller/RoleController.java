package com.sgcc.jxd.microservicelogin.controller;

import com.sgcc.jxd.microservicelogin.bean.Rolers;
import com.sgcc.jxd.microservicelogin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rolers")
@RefreshScope
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public List<Rolers> listRoler(){
        return roleService.listRolers();
    }
}

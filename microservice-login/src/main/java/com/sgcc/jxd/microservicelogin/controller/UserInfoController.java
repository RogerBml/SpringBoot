package com.sgcc.jxd.microservicelogin.controller;

import com.sgcc.jxd.microservicelogin.bean.UserInfo;
import com.sgcc.jxd.microservicelogin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/admin")
@RefreshScope
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @PostMapping("/login")
    public Map userinfoLogin(UserInfo user){
         return userInfoService.loginByUserInfo(user);
    }
    @PostMapping("/registory")
    public Map  userinfoRegistory(@RequestBody UserInfo user){
        return userInfoService.saveUesrInfo(user);
    };
    @GetMapping("/userinfo/{id}")
    public UserInfo getUserInfo(@PathVariable("id") int id){
        return userInfoService.getUesrInfoById(id);
    }
    @GetMapping("/list")
    public List<UserInfo> ListUserinfo(){
        return userInfoService.listUesrInfo();
    };

}

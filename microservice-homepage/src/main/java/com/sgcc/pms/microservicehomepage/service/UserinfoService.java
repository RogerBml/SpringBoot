package com.sgcc.pms.microservicehomepage.service;

import com.sgcc.pms.microservicehomepage.bean.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "microservice-login",fallbackFactory = UserinfoFallBackFactory.class)
@Service
@RequestMapping("/v1/admin")
public interface UserinfoService {
    @PostMapping("/login")
    public Map userinfoLogin(UserInfo user);
    @PostMapping("/registory")
    public Map  userinfoRegistory(UserInfo user);
    @GetMapping("/userinfo/{id}")
    public UserInfo getUserInfo(@PathVariable("id")int id);
}

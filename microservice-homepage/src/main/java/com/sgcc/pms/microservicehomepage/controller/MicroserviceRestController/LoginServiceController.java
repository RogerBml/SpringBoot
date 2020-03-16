package com.sgcc.pms.microservicehomepage.controller.MicroserviceRestController;

import com.sgcc.pms.microservicehomepage.bean.UserInfo;
import com.sgcc.pms.microservicehomepage.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/userinfo")
public class LoginServiceController {
    @Autowired
    private UserinfoService userinfoService;
    @PostMapping("/login")
    public Map userinfoLogin(UserInfo user){

        return userinfoService.userinfoLogin(user);
    }
    @PostMapping("/registory")
    public Map  userinfoRegistory(UserInfo user)
    {
        return userinfoService.userinfoRegistory(user);
    };
    @GetMapping("/userinfo/{id}")
    public UserInfo getUserInfo(@PathVariable("id") int id){

        return userinfoService.getUserInfo(id);
    }

}

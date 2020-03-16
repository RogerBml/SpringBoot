package com.sgcc.pms.microservicehomepage.service;

import com.sgcc.pms.microservicehomepage.bean.UserInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserinfoFallBackFactory implements FallbackFactory<UserinfoService> {
    @Override
    public UserinfoService create(Throwable throwable) {
        return new UserinfoService(){
            @Override
            public Map userinfoLogin(UserInfo user) {
               Map<Object, Object> map = new HashMap<>();
                map.put("mes","获取登陆服务失败");
                return map;
            }

            @Override
            public Map userinfoRegistory(UserInfo user) {
                Map<Object, Object> map = new HashMap<>();
                map.put("mes","获取注册服务失败");
                return map;
            }

            @Override
            public UserInfo getUserInfo(@PathVariable("id")int id) {
                UserInfo info = new UserInfo();
                info.setUsername("获取用户信息失败");
                return info;
            }
        };
    }
}

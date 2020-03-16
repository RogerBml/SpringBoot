package com.sgcc.jxd.microservicelogin.service;

import com.sgcc.jxd.microservicelogin.bean.UserInfo;
import com.sgcc.jxd.microservicelogin.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoRepository userinfoRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map saveUesrInfo(UserInfo user) {
        Map<String,Object> map = new HashMap<>();
        UserInfo users = userinfoRepository.save(user);
           if(users !=null){
            map.put("code","200");
            return map;
        }else{
            map.put("code","201");
        }
        return map;
    }

    @Override
    public boolean removeUesrInfoById(int id) {
        return false;
    }

    @Override
    public boolean modifyUesrInfo(UserInfo user) {
        return false;
    }

    @Override
    public UserInfo getUesrInfoById(int id) {
        if(userinfoRepository.existsById(id)){
            return userinfoRepository.getOne(id);
        }else{
            return new UserInfo();
        }
    }

    @Override
    public Map loginByUserInfo(UserInfo user) {
        UserInfo userInfo = userinfoRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        Map<String,Object> result = new HashMap();
        if(userInfo !=null){
            String token = UUID.randomUUID().toString();
            result.put("code",20000);
            result.put("token", token);
            redisTemplate.opsForValue().set(token,user,30000, TimeUnit.SECONDS);
            Cookie cookie = new Cookie("tocken",token);
            cookie.setMaxAge(30000);
            cookie.setPath("/");
        }else{
            result.put("message","登陆失败，请验证用户名密码");
        }
        return result;
    }

    public List<UserInfo> listUesrInfo(){
        return userinfoRepository.findAll();

    }
}

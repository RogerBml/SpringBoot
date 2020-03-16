package com.sgcc.jxd.microservicelogin.service;

import com.sgcc.jxd.microservicelogin.bean.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

        Map saveUesrInfo(UserInfo user);
        boolean removeUesrInfoById(int id);
        boolean modifyUesrInfo(UserInfo user);
        UserInfo getUesrInfoById(int id);
        Map loginByUserInfo(UserInfo user);
        List<UserInfo> listUesrInfo();
}

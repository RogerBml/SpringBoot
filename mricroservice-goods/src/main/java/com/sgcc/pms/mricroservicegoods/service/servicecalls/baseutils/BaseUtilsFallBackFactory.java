package com.sgcc.pms.mricroservicegoods.service.servicecalls.baseutils;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BaseUtilsFallBackFactory implements FallbackFactory<BaseUtils> {
    @Override
    public BaseUtils create(Throwable throwable) {
        return  new BaseUtils(){
            @Override
            public String getTime() {
                SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return formate.format(new Date());
            }
        };
    }
}

package com.sgcc.jxd.microserviceorders.service.goodsService;

import com.sgcc.jxd.microserviceorders.bean.Policy;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GoodsCallServiceFallBackFactory implements FallbackFactory<GoodsCallService> {
    @Override
    public GoodsCallService create(Throwable throwable) {
        return new GoodsCallService() {

            @Override
            public Policy findPolicyBySkuid(int skuid) {
                log.info("*************开启熔断*********");
                return new Policy();
            }
        };
    }
}

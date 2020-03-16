package com.sgcc.jxd.microserviceorders.service.goodsService;

import com.sgcc.jxd.microserviceorders.bean.Policy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "microservice-goods",
        fallbackFactory = GoodsCallServiceFallBackFactory.class)
@Service
@RequestMapping("/policy")
public interface GoodsCallService {
    @GetMapping("/{sku_id}")
    public Policy findPolicyBySkuid(@PathVariable("sku_id") int sku_id);
}

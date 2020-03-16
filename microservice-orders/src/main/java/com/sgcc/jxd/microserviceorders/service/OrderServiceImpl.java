package com.sgcc.jxd.microserviceorders.service;

import com.sgcc.jxd.microserviceorders.bean.Order;
import com.sgcc.jxd.microserviceorders.bean.Policy;
import com.sgcc.jxd.microserviceorders.repository.OrderRepository;
import com.sgcc.jxd.microserviceorders.service.goodsService.GoodsCallService;
import com.sgcc.jxd.microserviceorders.service.mqstream.StorageOutMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private StorageOutMessageService storageOutMessageService;

    @Autowired
    private GoodsCallService goodsCallService;

    public boolean createOrder(int sku_id, int user_id) {

        String order_id = String.valueOf(System.currentTimeMillis());
        Policy policy = goodsCallService.findPolicyBySkuid(sku_id);

        // Object skuMapobj = redisTemplate.boundValueOps("SKU_" + sku_id).get();

        if (policy != null && !policy.equals("")) {
            try {
                Date begin_time = policy.getBeginTime();
                Date end_time = policy.getEndTime();
                Date now = new Date();
                if (begin_time.getTime() < now.getTime() && end_time.getTime() > now.getTime()) {
                    long limitQuanty = Long.parseLong(String.valueOf(policy.getQuanty()));
                    if (redisTemplate.opsForValue().increment("SKU_QUANTY_" + sku_id, 1) <= limitQuanty) {
                        Order orderInfo = new Order();
                        orderInfo.setOrderId(order_id);
                        orderInfo.setActualFee(policy.getPrice());
                        orderInfo.setCreateTime(now);
                        orderInfo.setPaymentType(0);
                        orderInfo.setPostFee(0);
                        orderInfo.setUserId(user_id);
                        orderInfo.setStatus(1);
                        orderInfo.setSkuId(sku_id);
                        orderInfo.setNum(1);
                        Order order = repository.save(orderInfo);
                        if (order != null) {
                            storageOutMessageService.send(sku_id);
                            redisTemplate.opsForValue().set("ORDER_" + order_id, orderInfo);
                        }
/*                        orderInfo.put("title", skuMap.get("title"));
                        orderInfo.put("own_spec", skuMap.get("own spec"));
                        orderInfo.put("price", policy.get("price"));
                        orderInfo.put("image", skuMap.get("images"));*/

                    } else {
                        log.info("***************商品已经售完**********");
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}

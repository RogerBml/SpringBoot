package com.sgcc.pms.mricroservicegoods.service;

import com.sgcc.pms.mricroservicegoods.bean.Goods;
import com.sgcc.pms.mricroservicegoods.bean.Policy;
import com.sgcc.pms.mricroservicegoods.repository.GoodsRepository;
import com.sgcc.pms.mricroservicegoods.service.servicecalls.baseutils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private BaseUtils baseUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Goods> listGoods() {

        List<Goods> list =  goodsRepository.findAll();
        for(Goods good:list){
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String systime = baseUtils.getTime();
                Date nowTime = format.parse(systime);
              //  BoundValueOperations boundPolicyOperations = redisTemplate.boundValueOps("LIMIT_POLICY_" + good.getSku_id());
                Policy policy = (Policy)redisTemplate.opsForValue().get("LIMIT_POLICY_" + good.getSku_id());
                if(policy !=null&&policy.getBeginTime().getTime()<=nowTime.getTime()&&
                        policy.getEndTime().getTime()>=nowTime.getTime()
                ){
                    good.setPrice(policy.getPrice());
                   // good.setStock(policy.getQuanty());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Goods getGood(int sku_id) {
        return goodsRepository.getOne(sku_id);
    }
}

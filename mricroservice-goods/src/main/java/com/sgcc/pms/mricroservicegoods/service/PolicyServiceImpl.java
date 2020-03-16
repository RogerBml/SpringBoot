package com.sgcc.pms.mricroservicegoods.service;

import com.sgcc.pms.mricroservicegoods.bean.Policy;
import com.sgcc.pms.mricroservicegoods.repository.PolicyRepository;
import com.sgcc.pms.mricroservicegoods.service.servicecalls.baseutils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BaseUtils baseUtils;
    @Override
    //@CacheEvict(value = "goodsCache",allEntries = true)
    public boolean inserLimitPolicy(Policy policy) {
        Policy policy1 = policyRepository.save(policy);
        if(policy1 !=null){
            Long diff = 0L;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String systime = baseUtils.getTime();
                Date nowTime = format.parse(systime);
                Date endTime = policy1.getEndTime();
                diff = (endTime.getTime()-nowTime.getTime())/1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            redisTemplate.boundValueOps("LIMIT_POLI_"+policy1.getSkuId())
                    .set(policy1,diff, TimeUnit.SECONDS);
            return true;
        }else{
            return false;
        }
    }
   // @Cacheable(value = "goodsCache",key = " 'LIMIT_POLI_'+#skuid")
    public Policy findPolicyBySkuid(int skuid){
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("LIMIT_POLI_" + skuid);
        Policy po = (Policy)ops.get();
        if(po ==null){
            synchronized (this){
                 po = (Policy)ops.get();
                if(po==null){
                    po = policyRepository.findAllBySkuId(skuid);
                    Long diff = 0L;
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String systime = baseUtils.getTime();
                        Date nowTime = format.parse(systime);
                        Date endTime = po.getEndTime();
                        diff = (endTime.getTime()-nowTime.getTime())/1000;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    redisTemplate.boundValueOps("LIMIT_POLI_"+po.getSkuId())
                            .set(po,diff, TimeUnit.SECONDS);
                }
            }
        }

        return po;
    }

    @Override
    @CacheEvict(value = "goodsCache",allEntries = true)
    public boolean removePolicyBySkuid(int sku_id) {
        Policy policy = policyRepository.deleteAllBySkuId(sku_id);
        return false;
    }

    @Override
    @CacheEvict(value = "goodsCache",allEntries = true)
    public boolean modifyPolicyBySkuid(Policy policy) {
        policyRepository.save(policy);
        return false;
    }
}

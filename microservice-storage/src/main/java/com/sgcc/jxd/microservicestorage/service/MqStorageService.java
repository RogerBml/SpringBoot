package com.sgcc.jxd.microservicestorage.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
@EnableBinding(Sink.class)
public class MqStorageService {

    @Resource
    private StockService stockService;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {
        boolean b = stockService.SaveStock(Integer.parseInt(message.getPayload()), 0, 1);
        if(b){
            log.info("******更新库存成功:"+message.getPayload());

        }
    }

}

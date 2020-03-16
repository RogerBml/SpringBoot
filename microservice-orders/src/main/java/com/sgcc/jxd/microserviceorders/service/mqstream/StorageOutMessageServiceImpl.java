package com.sgcc.jxd.microserviceorders.service.mqstream;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class)
@Slf4j
public class StorageOutMessageServiceImpl implements StorageOutMessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send(Object obj) {
        // String  serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(obj).build());
        log.info("***********发送消息成功***********");
        return null;
    }
}

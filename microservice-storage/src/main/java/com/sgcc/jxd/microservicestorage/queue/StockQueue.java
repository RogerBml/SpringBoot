package com.sgcc.jxd.microservicestorage.queue;

import com.sgcc.jxd.microservicestorage.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
//@Component
public class StockQueue {

    @Autowired
    private StockService stockService;
   // @RabbitListener(queues = "Storage_queue")
    public void insertStorage(String msg){
        log.info("storage_queue接收消息："+msg);
        boolean b = stockService.SaveStock(Integer.parseInt(msg), 0, 1);
        if(!b){
            log.info("storage_queue处理消息失败");
        }else{
            log.info("storage_queue处理消息成功");

        }
    }

}

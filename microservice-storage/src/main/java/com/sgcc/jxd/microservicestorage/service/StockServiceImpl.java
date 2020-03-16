package com.sgcc.jxd.microservicestorage.service;

import com.sgcc.jxd.microservicestorage.Reposity.StockHistoryReposity;
import com.sgcc.jxd.microservicestorage.Reposity.StockReposity;
import com.sgcc.jxd.microservicestorage.bean.Storage;
import com.sgcc.jxd.microservicestorage.bean.StorageHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockReposity stockReposity;
    @Autowired
    private StockHistoryReposity stockHistoryReposity;

    @Override
    @Transactional
    public boolean SaveStock(int sku_id,int in_quanty,int out_quanty) {

        try {
            Storage storage = stockReposity.findAllBySkuId(sku_id);
            int quanty = in_quanty-out_quanty;
            if(storage !=null){
                StorageHistory storageHistory = new StorageHistory();
                storageHistory.setSku_id(sku_id);
                storageHistory.setIn_quanty(in_quanty);
                storageHistory.setOut_quanty(out_quanty);
                storageHistory.setStock_storage_id(storage.getId());
                stockHistoryReposity.save(storageHistory);
                storage.setQuanty(storage.getQuanty()+quanty);
                stockReposity.save(storage);
            }else{
                stockReposity.saveReposity(sku_id, quanty);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

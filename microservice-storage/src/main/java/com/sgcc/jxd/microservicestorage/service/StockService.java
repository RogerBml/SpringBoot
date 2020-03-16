package com.sgcc.jxd.microservicestorage.service;


public interface StockService {
    public boolean SaveStock(int sku_id,int in_quanty,int out_quanty);
}

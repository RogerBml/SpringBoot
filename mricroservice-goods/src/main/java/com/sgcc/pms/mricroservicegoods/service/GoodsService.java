package com.sgcc.pms.mricroservicegoods.service;

import com.sgcc.pms.mricroservicegoods.bean.Goods;

import java.util.List;

public interface GoodsService {

    public List<Goods> listGoods();

    public Goods getGood(int sku_id);
}

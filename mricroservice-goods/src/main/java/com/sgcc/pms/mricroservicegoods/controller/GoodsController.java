package com.sgcc.pms.mricroservicegoods.controller;

import com.sgcc.pms.mricroservicegoods.bean.Goods;
import com.sgcc.pms.mricroservicegoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/listGoods")
    public List<Goods> listGoods(){
        return goodsService.listGoods();
    }
}

package com.sgcc.jxd.microservicestorage.controller;


import com.sgcc.jxd.microservicestorage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;
    @GetMapping("/stock/{sku_id}/{in_quanty}/{out_quanty}")
    public boolean SaveStock(@PathVariable(value = "sku_id") int sku_id,
        @PathVariable(value = "in_quanty")int in_quanty, @PathVariable(value = "out_quanty")int out_quanty){
        return stockService.SaveStock(sku_id,in_quanty,out_quanty);
    }

}

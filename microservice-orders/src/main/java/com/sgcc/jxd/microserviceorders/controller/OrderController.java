package com.sgcc.jxd.microserviceorders.controller;

import com.sgcc.jxd.microserviceorders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public boolean createOrder(@RequestParam(value = "sku_id") int sku_id,
                               @RequestParam(value = "user_id") int user_id) {
        return orderService.createOrder(sku_id, user_id);
    }
}


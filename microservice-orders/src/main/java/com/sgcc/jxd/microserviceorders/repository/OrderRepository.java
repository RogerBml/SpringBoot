package com.sgcc.jxd.microserviceorders.repository;

import com.sgcc.jxd.microserviceorders.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends JpaRepository<Order, String> {
}

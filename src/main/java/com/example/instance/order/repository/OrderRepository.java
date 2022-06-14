package com.example.instance.order.repository;

import com.example.instance.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderRepository {
    public void insertOrderBase(OrderDto dto) {
        log.info("OrderRepository.insertOrderBase request: {}", dto);
    }

    public void insertOrderProduct(OrderDto dto) {
        log.info("OrderRepository.insertOrderProduct request: {}", dto);
    }

    public void insertOrderClaim(OrderDto dto) {
        log.info("OrderRepository.insertOrderClaim request: {}", dto);
    }
}

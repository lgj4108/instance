package com.example.instance.order.strategy.after.impl;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.strategy.after.AfterStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoAfterStrategy implements AfterStrategy {
    @Override
    public void call(OrderRequest request, OrderDto dto) {
        log.info("bo after strategy : {}, {}", request, dto);
    }
}

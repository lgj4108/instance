package com.example.instance.order.strategy.data.impl;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderProductView;
import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.strategy.data.DataCreateStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class EcouponDataCreateStrategy implements DataCreateStrategy {
    @Override
    public OrderDto create(OrderRequest request, List<OrderProductView> productView) {
        log.info("EcouponDataCreateStrategy : {}, {}", request, productView);
        return new OrderDto();
    }
}

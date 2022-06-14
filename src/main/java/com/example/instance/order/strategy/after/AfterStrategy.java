package com.example.instance.order.strategy.after;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderRequest;

public interface AfterStrategy {
    void call(OrderRequest request, OrderDto dto);
}

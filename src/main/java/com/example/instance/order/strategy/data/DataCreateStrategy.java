package com.example.instance.order.strategy.data;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderProductView;
import com.example.instance.order.dto.OrderRequest;

import java.util.List;

public interface DataCreateStrategy {
    OrderDto create(OrderRequest request, List<OrderProductView> productView);
}

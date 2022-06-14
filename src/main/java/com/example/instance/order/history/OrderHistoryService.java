package com.example.instance.order.history;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderHistoryService {

    private final OrderHistoryRepository historyRepository;

    public Long insertOrderHistory(OrderRequest request) {
        log.info("OrderHistoryService.insertOrderHistory request : {}", request);
        return historyRepository.insertOrderHistory(request);
    }

    public void updateOrderHistory(Long historyNo, OrderDto dto) {
        log.info("OrderHistoryService.updateOrderHistory request : {}, {}", historyNo, dto);
        historyRepository.updateOrderHistory(historyNo, dto);
    }


}

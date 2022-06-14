package com.example.instance.order.service;

import com.example.instance.order.context.OrderContext;
import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.history.OrderHistoryService;
import com.example.instance.order.repository.OrderRepository;
import com.example.instance.order.strategy.after.AfterStrategy;
import com.example.instance.order.strategy.after.impl.BoAfterStrategy;
import com.example.instance.order.strategy.after.impl.FoAfterStrategy;
import com.example.instance.order.strategy.data.DataCreateStrategy;
import com.example.instance.order.strategy.data.impl.EcouponDataCreateStrategy;
import com.example.instance.order.strategy.data.impl.GeneralDataCreateStrategy;
import com.example.instance.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderHistoryService historyService;
    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    public void order(OrderRequest orderRequest) {
        log.info("OrderService.order request: {}", orderRequest);
        OrderContext context = new OrderContext(historyService, paymentService, orderRepository);
        context.excute(getDataStrategy(orderRequest), getAfterStrategy(orderRequest), orderRequest);
    }

    private DataCreateStrategy getDataStrategy(OrderRequest request) {
        log.info("OrderService.getDataStrategy request: {}", request);
        DataCreateStrategy strategy = null;
        if("general".equals(request.getOrderType())) {
            strategy = new GeneralDataCreateStrategy();
        } else if ("ecoupon".equals(request.getOrderType())) {
            strategy = new EcouponDataCreateStrategy();
        }

        return strategy;
    }

    private AfterStrategy getAfterStrategy(OrderRequest request) {
        log.info("OrderService.getAfterStrategy request: {}", request);
        AfterStrategy strategy = null;
        if("FO".equals(request.getSystemType())) {
            strategy = new FoAfterStrategy();
        } else if ("BO".equals(request.getSystemType())) {
            strategy = new BoAfterStrategy();
        }

        return strategy;
    }
}

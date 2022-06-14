package com.example.instance.order.context;

import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderProductView;
import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.dto.OrderValidationDto;
import com.example.instance.order.history.OrderHistoryService;
import com.example.instance.order.repository.OrderRepository;
import com.example.instance.order.strategy.after.AfterStrategy;
import com.example.instance.order.strategy.data.DataCreateStrategy;
import com.example.instance.order.validation.OrderValidator;
import com.example.instance.payment.PaymentService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
public class OrderContext {
    private OrderHistoryService historyService;
    private PaymentService paymentService;
    private OrderRepository orderRepository;

    public OrderContext(OrderHistoryService historyService, PaymentService paymentService, OrderRepository orderRepository) {
        this.historyService = historyService;
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public void excute(DataCreateStrategy create, AfterStrategy after, OrderRequest request) {
        Long historyNo = historyService.insertOrderHistory(request);
        OrderDto dto = null;
        try {
            // validation
            OrderValidator.get(request).test(new OrderValidationDto(request, Arrays.asList(new OrderProductView())));

            // 데이터 생성
            dto = create.create(request, Arrays.asList(new OrderProductView()));

            // 주문 데이터 입력
            insertOrderData(dto);

            // 금액검증
            amountValidation(request.getOrderNo());

            // 후처리
            after.call(request, dto);
        } catch (Exception ex) {
            log.info("error: {}", ex);
        } finally {
            historyService.updateOrderHistory(historyNo, dto);
        }
    }

    private void insertOrderData(OrderDto dto) {
        log.info("OrderContext.insertOrderData request: {}", dto);
        orderRepository.insertOrderBase(dto);
        orderRepository.insertOrderProduct(dto);
        orderRepository.insertOrderClaim(dto);

    }

    private void amountValidation(String orderNo) {
        log.info("OrderContext.amountValidation request: {}", orderNo);
    }
}

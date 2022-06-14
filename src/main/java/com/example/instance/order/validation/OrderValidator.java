package com.example.instance.order.validation;

import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.dto.OrderValidationDto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum OrderValidator implements Predicate<OrderValidationDto> {
    FO_GENERAL("FO","general", OrderProductValidator.aaa.and(OrderProductValidator.aaa)),
    BO_GENERAL("BO", "general", OrderProductValidator.aaa.and(OrderProductValidator.aaa)),
    FO_ECOUPON("FO", "ecoupon", OrderProductValidator.aaa.and(OrderProductValidator.aaa)),
    BO_ECOUPON("BO", "ecoupon", OrderProductValidator.aaa.and(OrderProductValidator.aaa)),
    ;

    private String systemType;
    private String orderType;
    private Predicate<OrderValidationDto> predicate;

    OrderValidator(String systemType, String orderType, Predicate<OrderValidationDto> predicate) {
        this.systemType = systemType;
        this.orderType = orderType;
        this.predicate = predicate;
    }

    public boolean test(OrderValidationDto s) {
        return predicate.test(s);
    }

    public static OrderValidator get(OrderRequest request) {
        return Arrays.stream(OrderValidator.values()).filter((e) -> e.systemType.equals(request.getSystemType()) && e.orderType.equals(request.getOrderType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}

package com.example.instance.order.validation;

import com.example.instance.order.dto.OrderValidationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class OrderTypeValidator {
    public static Predicate<OrderValidationDto> isAbleEcouponOrder = (dto) -> {
        log.info("OrderTypeValidator.isAbleEcouponOrder: {}", dto);
        return dto != null;
    };
}

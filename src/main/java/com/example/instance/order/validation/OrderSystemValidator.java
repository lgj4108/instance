package com.example.instance.order.validation;

import com.example.instance.order.dto.OrderValidationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class OrderSystemValidator {
    public static Predicate<OrderValidationDto> isAbleBoOrder = (dto) -> {
        log.info("OrderSystemValidator.isAbleBoOrder: {}", dto);
        return dto != null;
    };
}

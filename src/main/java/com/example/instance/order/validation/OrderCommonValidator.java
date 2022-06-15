package com.example.instance.order.validation;

import com.example.instance.order.dto.OrderValidationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class OrderCommonValidator {
    public static Predicate<OrderValidationDto> commonValidator = (dto) -> {
        log.info("OrderCommonValidator.commonValidation : {}", dto);
        return dto != null;
    };
}

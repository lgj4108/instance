package com.example.instance.order.validation;

import com.example.instance.order.dto.OrderValidationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class OrderProductValidator {

    public static Predicate<OrderValidationDto> aaa = (dto) -> {log.info("validation:: {}", dto); return dto != null; };
}

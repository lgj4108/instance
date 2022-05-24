package com.example.instance.enums.service.impl;

import com.example.instance.enums.service.InstanceEnumService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstanceEnumServiceOne implements InstanceEnumService {

    @Override
    public void showLog(String message) {
        log.info("service one message: {}", message);
    }
}

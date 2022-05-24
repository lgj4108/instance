package com.example.instance.enums.service.impl;

import com.example.instance.enums.service.InstanceEnumService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstanceEnumServiceTwo implements InstanceEnumService {
    @Override
    public void showLog(String message) {
        log.info("service two message: {}", message);
    }
}

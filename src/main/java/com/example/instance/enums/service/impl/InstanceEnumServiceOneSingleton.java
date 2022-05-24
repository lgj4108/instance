package com.example.instance.enums.service.impl;

import com.example.instance.enums.service.InstanceEnumService;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class InstanceEnumServiceOneSingleton implements InstanceEnumService {
    private static InstanceEnumServiceOneSingleton instance;

    @Override
    public void showLog(String message) {
        log.info("singleton one: {}", message);
    }

    private InstanceEnumServiceOneSingleton() {

    }

    public static InstanceEnumServiceOneSingleton getInstance() {
        if(Objects.isNull(instance)) {
            synchronized (InstanceEnumServiceOneSingleton.class) {
                instance = new InstanceEnumServiceOneSingleton();
            }
        }
        return instance;
    }
}

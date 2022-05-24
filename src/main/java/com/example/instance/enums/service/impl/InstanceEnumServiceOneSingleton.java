package com.example.instance.enums.service.impl;

import com.example.instance.enums.service.InstanceEnumService;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class InstanceEnumServiceOneSingleton implements InstanceEnumService {
    private static InstanceEnumServiceOneSingleton instance;

    @Override
    public void showLog(String message) {
        log.info("service two message: {}, {}", message, sum);
    }

    private InstanceEnumServiceOneSingleton() {

    }

    public static InstanceEnumServiceOneSingleton getInstance() {
        if(Objects.isNull(instance)) {
            instance = new InstanceEnumServiceOneSingleton();
        }
        return instance;
    }

    private int sum = 1;

    public void addNum(int num) {
        sum = sum + num;
        log.info("service one sum: {}", sum);
    }
}

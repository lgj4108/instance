package com.example.instance.enums.service.impl;

import com.example.instance.enums.service.InstanceEnumService;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class InstanceEnumServiceTwoSingleton implements InstanceEnumService {
    private static InstanceEnumServiceTwoSingleton instance;

    @Override
    public void showLog(String message) {
        log.info("service two message: {}, {}", message, sum);
    }

    private InstanceEnumServiceTwoSingleton() {

    }

    public static InstanceEnumServiceTwoSingleton getInstance() {
        if(Objects.isNull(instance)) {
            synchronized (InstanceEnumServiceTwoSingleton.class) {
                instance = new InstanceEnumServiceTwoSingleton();
            }
        }
        return instance;
    }

    private int sum = 1;

    public void addNum(int num) {
        sum = sum + num;
        log.info("service one sum: {}", sum);
    }
}

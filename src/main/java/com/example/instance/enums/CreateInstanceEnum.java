package com.example.instance.enums;

import com.example.instance.enums.service.InstanceEnumService;
import com.example.instance.enums.service.impl.InstanceEnumServiceOne;
import com.example.instance.enums.service.impl.InstanceEnumServiceOneSingleton;
import com.example.instance.enums.service.impl.InstanceEnumServiceTwo;
import com.example.instance.enums.service.impl.InstanceEnumServiceTwoSingleton;

import java.util.Arrays;
import java.util.function.Supplier;

public enum CreateInstanceEnum {
    ONE("one", new InstanceEnumServiceOne(), () -> new InstanceEnumServiceOne(), InstanceEnumServiceOneSingleton.getInstance(), () -> InstanceEnumServiceOneSingleton.getInstance()),
    TWO("two", new InstanceEnumServiceTwo(), () -> new InstanceEnumServiceTwo(), InstanceEnumServiceTwoSingleton.getInstance(), () -> InstanceEnumServiceTwoSingleton.getInstance()),
    ;

    private String type;
    private InstanceEnumService instanceEnumServiceNewInstance;
    private Supplier<InstanceEnumService> instanceEnumServiceTypeFunction;

    private InstanceEnumService instanceEnumServiceSingleton;

    private Supplier<InstanceEnumService> instanceEnumServiceSingletonTypeFunction;
    CreateInstanceEnum(String type, InstanceEnumService instanceEnumServiceNewInstance, Supplier<InstanceEnumService> instanceEnumServiceTypeFunction, InstanceEnumService instanceEnumServiceSingleton, Supplier<InstanceEnumService> instanceEnumServiceSingletonTypeFunction) {
        this.type = type;
        this.instanceEnumServiceNewInstance = instanceEnumServiceNewInstance;
        this.instanceEnumServiceTypeFunction = instanceEnumServiceTypeFunction;
        this.instanceEnumServiceSingleton = instanceEnumServiceSingleton;
        this.instanceEnumServiceSingletonTypeFunction = instanceEnumServiceSingletonTypeFunction;
    }

    public static CreateInstanceEnum getEnum(String type) {
        return Arrays.stream(CreateInstanceEnum.values())
                .filter(i -> i.type.equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    public static InstanceEnumService getService(String type)  {
        return CreateInstanceEnum
                .getEnum(type)
                .instanceEnumServiceNewInstance;
    }

    public static InstanceEnumService getService2th(String type)  {
        return CreateInstanceEnum
                .getEnum(type)
                .instanceEnumServiceTypeFunction
                .get();
    }

    public static InstanceEnumService getService3th(String type)  {
        return CreateInstanceEnum
                .getEnum(type)
                .instanceEnumServiceSingleton;
    }

    public static InstanceEnumService getService4th(String type)  {
        return CreateInstanceEnum
                .getEnum(type)
                .instanceEnumServiceSingletonTypeFunction
                .get();
    }

}


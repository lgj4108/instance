package com.example.instance.inject.service;

import com.example.instance.config.ApplicationContextProvider;

public class InjectBeanInstanct {
    private InjectService injectService;

    public InjectBeanInstanct() {
        this.injectService = ApplicationContextProvider.getBean(InjectService.class);
    }

    public void testInject(String param) {
        System.out.println("start");

        injectService.injected();

        SingletonInstance.getInstance().setText1("test" + param);
        SingletonInstance.getInstance().sysout("start");

        System.out.println("end");
    }
}

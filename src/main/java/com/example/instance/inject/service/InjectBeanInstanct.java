package com.example.instance.inject.service;

import com.example.instance.config.ApplicationContextProvider;
import com.example.instance.config.BeanFactoryProvider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InjectBeanInstanct {
    private InjectService injectApplicationContextService;
    private InjectService injectBeanFactoryService;

    public InjectBeanInstanct() {
        this.injectApplicationContextService = ApplicationContextProvider.getBean(InjectService.class);
        this.injectBeanFactoryService = BeanFactoryProvider.getBean(InjectService.class);
    }

    public void testInject(String param) {
        log.info("start");

        InjectService innerInjectBeanFactoryService = BeanFactoryProvider.getBean(InjectService.class);

        log.info("injectApplicationContextService :: {}", injectApplicationContextService);
        log.info("injectBeanFactoryService :: {}", injectBeanFactoryService);
        log.info("innerInjectBeanFactoryService :: {}", innerInjectBeanFactoryService);

        injectApplicationContextService.injected();
        injectBeanFactoryService.injected();

        SingletonInstance.getInstance().setText1("test" + param);
        SingletonInstance.getInstance().sysout("start");

        log.info("end");
    }
}

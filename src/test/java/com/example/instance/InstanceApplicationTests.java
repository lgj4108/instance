package com.example.instance;

import com.example.instance.enums.CreateInstanceEnum;
import com.example.instance.inject.service.InjectBeanInstanct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InstanceApplicationTests {

    @Test
    void contextLoads() {
        InjectBeanInstanct injectBeanInstanct = new InjectBeanInstanct();
        injectBeanInstanct.testInject("test");
        injectBeanInstanct.testInject("test1111");

        InjectBeanInstanct injectBeanInstanctSecond = new InjectBeanInstanct();
        injectBeanInstanctSecond.testInject("test22");
        injectBeanInstanctSecond.testInject("test22222");

    }

    @Test
    void enumTest() {
        log.info("instance: {}", CreateInstanceEnum.getService("one"));
        log.info("instance: {}", CreateInstanceEnum.getService("one"));
        log.info("instance: {}", CreateInstanceEnum.getService("two"));
        log.info("instance: {}", CreateInstanceEnum.getService("two"));

        log.info("instance function: {}", CreateInstanceEnum.getService2th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService2th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService2th("two"));
        log.info("instance function: {}", CreateInstanceEnum.getService2th("two"));

        log.info("instance function: {}", CreateInstanceEnum.getService3th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService3th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService3th("two"));
        log.info("instance function: {}", CreateInstanceEnum.getService3th("two"));

        log.info("instance function: {}", CreateInstanceEnum.getService4th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService4th("one"));
        log.info("instance function: {}", CreateInstanceEnum.getService4th("two"));
        log.info("instance function: {}", CreateInstanceEnum.getService4th("two"));

        CreateInstanceEnum.getService("one").showLog("one 1th start");
        CreateInstanceEnum.getService("one").addNum(1);
        CreateInstanceEnum.getService("one").showLog("one 1th end");
        CreateInstanceEnum.getService("two").showLog("two 1th start");
        CreateInstanceEnum.getService("two").addNum(2);
        CreateInstanceEnum.getService("two").showLog("two 1th end");

        CreateInstanceEnum.getService2th("one").showLog("one 1th start");
        CreateInstanceEnum.getService2th("one").addNum(1);
        CreateInstanceEnum.getService2th("one").showLog("one 1th end");
        CreateInstanceEnum.getService2th("two").showLog("two 1th start");
        CreateInstanceEnum.getService2th("two").addNum(2);
        CreateInstanceEnum.getService2th("two").showLog("two 1th end");

        CreateInstanceEnum.getService3th("one").showLog("one 1th start");
        CreateInstanceEnum.getService3th("one").addNum(1);
        CreateInstanceEnum.getService3th("one").showLog("one 1th end");
        CreateInstanceEnum.getService3th("two").showLog("two 1th start");
        CreateInstanceEnum.getService3th("two").addNum(2);
        CreateInstanceEnum.getService3th("two").showLog("two 1th end");

        CreateInstanceEnum.getService4th("one").showLog("one 1th start");
        CreateInstanceEnum.getService4th("one").addNum(1);
        CreateInstanceEnum.getService4th("one").showLog("one 1th end");
        CreateInstanceEnum.getService4th("two").showLog("two 1th start");
        CreateInstanceEnum.getService4th("two").addNum(2);
        CreateInstanceEnum.getService4th("two").showLog("two 1th end");
    }
}

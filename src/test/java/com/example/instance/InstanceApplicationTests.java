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
    }
}

package com.example.instance;

import com.example.instance.enums.CreateInstanceEnum;
import com.example.instance.functional.dto.AClass;
import com.example.instance.functional.dto.BClass;
import com.example.instance.functional.dto.CClass;
import com.example.instance.functional.functions.ValidationFunction;
import com.example.instance.inject.service.InjectBeanInstanct;
import com.example.instance.order.dto.OrderDto;
import com.example.instance.order.dto.OrderProductView;
import com.example.instance.order.dto.OrderRequest;
import com.example.instance.order.dto.OrderValidationDto;
import com.example.instance.order.validation.OrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

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
//        log.info("instance: {}", CreateInstanceEnum.getService("one"));
//        log.info("instance: {}", CreateInstanceEnum.getService("one"));
//        log.info("instance: {}", CreateInstanceEnum.getService("two"));
//        log.info("instance: {}", CreateInstanceEnum.getService("two"));
//
//        log.info("instance function: {}", CreateInstanceEnum.getService2th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService2th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService2th("two"));
//        log.info("instance function: {}", CreateInstanceEnum.getService2th("two"));
//
//        log.info("instance function: {}", CreateInstanceEnum.getService3th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService3th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService3th("two"));
//        log.info("instance function: {}", CreateInstanceEnum.getService3th("two"));
//
//        log.info("instance function: {}", CreateInstanceEnum.getService4th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService4th("one"));
//        log.info("instance function: {}", CreateInstanceEnum.getService4th("two"));
//        log.info("instance function: {}", CreateInstanceEnum.getService4th("two"));

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

    @Test
    void functionTest() {
        Boolean isValid = ValidationFunction.validate1()
                .and(ValidationFunction.validate2())
                .and(ValidationFunction.validate2())
                .apply(0);

        log.info("isValid 0 : {}", isValid);
        Boolean isValid2 = ValidationFunction.validate1()
                .and(ValidationFunction.validate2())
                .apply(10);

        log.info("isValid 10 : {}", isValid2);

        Boolean isValid3 = ValidationFunction.validate1()
                .and(ValidationFunction.validate2())
                .apply(5);

        log.info("isValid 5 : {}", isValid3);

        Function<AClass, BClass> test = (AClass aClass) -> {
            log.info(String.valueOf(aClass.getA()));
            return new BClass(String.valueOf(aClass.getA() + 10));
        };

        Function<CClass, AClass> compose1 = (CClass cClass) -> {
            log.info(String.valueOf(cClass.getC()));
            return new AClass(cClass.getC() + 1000);
        };

        BClass aatest = test.compose(compose1).apply(new CClass(1000));

        log.info(aatest.getB());
    }
}

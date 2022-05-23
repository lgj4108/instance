package com.example.instance;

import com.example.instance.inject.service.InjectBeanInstanct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstanceApplicationTests {

    @Test
    void contextLoads() {
        InjectBeanInstanct injectBeanInstanct = new InjectBeanInstanct();
        injectBeanInstanct.testInject("test");

    }

}

package com.example.instance.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    protected void test() {
        log.info("test");
    }

    protected abstract void call();

}

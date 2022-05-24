package com.example.instance.inject.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class SingletonInstance {
    private static SingletonInstance instance;

    private SingletonInstance() {
    }

    public static SingletonInstance getInstance() {
        if(instance == null) {
            synchronized (SingletonInstance.class) {
                instance = new SingletonInstance();
            }
        }

        return instance;
    }

    private String text1;
    private String text2;

    public void setText1(String text) {
        this.text1 = text;
    }

    public void sysout(String text) {
        log.info(text);
        log.info(this.text1);
        log.info(this.text2);
    }
}

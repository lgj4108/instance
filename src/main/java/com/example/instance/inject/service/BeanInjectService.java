package com.example.instance.inject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BeanInjectService {
    InjectService injectService;

    public BeanInjectService(InjectService injectService) {
        this.injectService = injectService;
    }
}

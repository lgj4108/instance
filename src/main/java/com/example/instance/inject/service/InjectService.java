package com.example.instance.inject.service;

import org.springframework.stereotype.Service;

@Service
public class InjectService {
    public void injected() {
        System.out.println("injected");
    }
}

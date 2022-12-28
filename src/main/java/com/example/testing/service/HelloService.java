package com.example.testing.service;

import org.springframework.stereotype.Service;

import com.example.testing.repository.HelloRepository;

@Service
public class HelloService {
    HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public String get() {
        return helloRepository.get();
    }
}

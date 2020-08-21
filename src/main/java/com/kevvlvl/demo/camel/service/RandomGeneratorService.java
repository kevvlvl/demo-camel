package com.kevvlvl.demo.camel.service;

import org.apache.camel.Handler;
import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorService {

    @Handler
    public int getRandom() {
        return (int)(Math.random()*100);
    }
}

package com.qiuhuu.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : qiuhuu
 * @date : 2020-07-07 17-49
 */
@RestController
public class TestController {

    @GetMapping("/health")
    public String health(){
        return "health";
    }
}

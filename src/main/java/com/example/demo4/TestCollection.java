package com.example.demo4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCollection {

    @RequestMapping("hello")
    public String getValue(){
        return "hello world";
    }
}
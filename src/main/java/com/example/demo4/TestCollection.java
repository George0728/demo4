package com.example.demo4;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCollection {

    @RequestMapping("hello")
    public String getValue(){
        return "hello world";
    }

    @RequestMapping("index")
    public String getIndex(Model model) {
        model.addAttribute("value", "hello world");
        return "index";
    }
}
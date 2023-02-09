package com.example.demo4;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.demo4.system.mapper")
public class Demo4Application {

    public static void main(String[] args) {
        log.info("args:{}",args);
        SpringApplication.run(Demo4Application.class, args);
    }

}

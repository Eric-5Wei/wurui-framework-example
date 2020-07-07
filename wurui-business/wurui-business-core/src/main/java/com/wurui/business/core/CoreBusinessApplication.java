package com.wurui.business.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wurui.repository.core.mapper")
public class CoreBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreBusinessApplication.class, args);
    }
}

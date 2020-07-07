package com.wurui.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证与授权
 */
@SpringBootApplication(scanBasePackages = "com.wurui")
@MapperScan(basePackages = "com.wurui.repository.core.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}

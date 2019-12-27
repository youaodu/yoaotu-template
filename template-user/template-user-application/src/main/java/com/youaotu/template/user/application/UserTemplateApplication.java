package com.youaotu.template.user.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.youaotu.template")
public class UserTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserTemplateApplication.class, args);
    }
}

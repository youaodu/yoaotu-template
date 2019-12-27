package com.youaotu.template.admin.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.youaotu.template"})
public class AdminTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminTemplateApplication.class, args);
    }
}

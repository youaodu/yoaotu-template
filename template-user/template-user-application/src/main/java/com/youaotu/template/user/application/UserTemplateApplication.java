package com.youaotu.template.user.application;

import com.youaotu.template.common.framework.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.youaotu.template")
public class UserTemplateApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UserTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);
    }
}

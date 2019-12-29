package com.youaotu.template.admin.application;

import com.youaotu.template.common.framework.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.youaotu.template.common.entity.model"})
@SpringBootApplication(scanBasePackages = {"com.youaotu.template"})
@EnableJpaRepositories(basePackages = {"com.youaotu.template.common.dao"})
public class AdminTemplateApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AdminTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);
    }
}

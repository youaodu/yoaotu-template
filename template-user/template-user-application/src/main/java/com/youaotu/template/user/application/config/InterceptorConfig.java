package com.youaotu.template.user.application.config;

import com.youaotu.template.common.framework.resolvers.TokenResolvers;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.youaotu.template.common.framework.interceptor.TokenInterceptor;

import java.util.List;

/**
 * * @create 2019-08-11 06:36
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 跨域问题
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")    //允许所有前端站点调用
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(1728000);
    }

    /**
     * 解析参数所用
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TokenResolvers());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // token 拦截器
        registry.addInterceptor(new TokenInterceptor());
        super.addInterceptors(registry);
    }
}

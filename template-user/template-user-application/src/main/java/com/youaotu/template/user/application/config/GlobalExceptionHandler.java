package com.youaotu.template.user.application.config;

import com.youaotu.template.common.framework.exception.YouaoduExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 集成方法自定义了方法
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends YouaoduExceptionHandler {

}

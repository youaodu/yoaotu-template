package com.youaotu.template.admin.application.aop;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamAop {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(ParamAop.class);

    @Pointcut("execution(* com.youaotu.template.admin.controller.*..*.*(..))")
    public void methodBeforeParamLog() {}

    /**
     * 请求入参打印
     * @param point
     */
    @Before("methodBeforeParamLog()")
    public void methodBeforeParamLogAround(JoinPoint point) {
        MethodSignature signature = (MethodSignature)point.getSignature();
        // 拼接打印信息
        StringBuilder sb = new StringBuilder();
        sb.append("类: " + signature.getMethod().getDeclaringClass().getSimpleName());
        sb.append(" >>> 方法名: " + signature.getMethod().getName());
        sb.append(" >> 方法入参 [");
        String[] parameterNames = signature.getParameterNames();
        Object[] args = point.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i] + " > " + JSONUtil.toJsonStr(args[i]));
        }
        sb.append(" ]");
        logger.info(sb.toString());
    }
}

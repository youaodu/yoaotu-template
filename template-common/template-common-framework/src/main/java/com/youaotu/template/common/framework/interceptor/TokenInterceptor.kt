package com.youaotu.template.common.framework.interceptor

import com.youaotu.template.common.framework.annotation.WhiteRequest
import com.youaotu.template.common.framework.token.BuilderToken
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author youao.du@gmail.com
 * @create 2019-08-11 06:12
 */
class TokenInterceptor: HandlerInterceptor {

    /**
     * 效验Token
     * @author youao.du@gmail.com
     * @time 06:13
     * @params [request, http, handler]
     */
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // 判断接口是否检验token
        val handlerMethod: HandlerMethod = handler as HandlerMethod

        // 不用token 可过滤
        if (handlerMethod.method.isAnnotationPresent(WhiteRequest::class.java)) {
            return true
        }

        // 效验token是否有效
        if (!BuilderToken.validateToken(request.getHeader("Token"))) {
            return false
        }
        return true
    }
}
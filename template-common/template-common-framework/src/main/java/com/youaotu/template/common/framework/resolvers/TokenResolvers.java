package com.youaotu.template.common.framework.resolvers;

import com.youaotu.template.common.framework.token.BuilderToken;
import com.youaotu.template.common.framework.token.Token;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 把token解析为入参
 * @author youao.du@gmail.com
 * @time 2019-12-29 16:19
 */
public class TokenResolvers extends HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {

    private static final String TOKEN_NAME = "Token";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Token.class);
    }

    /**
     * 解析token值。返回token
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String tokenString = webRequest.getHeader(TOKEN_NAME);
        Token token = BuilderToken.analysisToken(tokenString);
        return token;
    }
}

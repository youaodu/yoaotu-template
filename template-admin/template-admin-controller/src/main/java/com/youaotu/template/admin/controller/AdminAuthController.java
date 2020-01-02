package com.youaotu.template.admin.controller;

import com.youaotu.template.admin.biz.AdminAuthBiz;
import com.youaotu.template.common.framework.http.ResultMessage;
import com.youaotu.template.common.framework.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 20:27
 */
@RestController
@RequestMapping("/auth")
public class AdminAuthController {

    @Autowired
    private AdminAuthBiz adminAuthBiz;

    @GetMapping("/authTree")
    public ResultMessage authTree(Token token) {
        return ResultMessage.ok(adminAuthBiz.authTree(token));
    }
}

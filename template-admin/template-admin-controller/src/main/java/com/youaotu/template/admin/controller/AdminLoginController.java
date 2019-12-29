package com.youaotu.template.admin.controller;

import com.youaotu.template.admin.biz.AdminLoginBiz;
import com.youaotu.template.common.entity.pojo.dto.admin.AdminLoginDto;
import com.youaotu.template.common.framework.annotation.WhiteRequest;
import com.youaotu.template.common.framework.http.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 16:30
 */
@RestController
@RequestMapping("/login")
public class AdminLoginController {

    @Autowired
    private AdminLoginBiz adminLoginBiz;

    /**
     * 后台登录接口
     * @return
     */
    @WhiteRequest
    @PostMapping
    public ResultMessage login(@RequestBody @Valid AdminLoginDto adminLoginDto) {
        return ResultMessage.ok(adminLoginBiz.login(adminLoginDto));
    }
}

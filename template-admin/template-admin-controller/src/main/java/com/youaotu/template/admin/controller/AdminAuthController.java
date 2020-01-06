package com.youaotu.template.admin.controller;

import com.youaotu.template.admin.biz.AdminAuthBiz;
import com.youaotu.template.common.entity.pojo.dto.admin.AdminCreditDto;
import com.youaotu.template.common.framework.http.ResultMessage;
import com.youaotu.template.common.framework.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 20:27
 */
@RestController
@RequestMapping("/auth")
public class AdminAuthController {

    @Autowired
    private AdminAuthBiz adminAuthBiz;

    /**
     * 路由菜单权限树
     * @param token
     * @return
     */
    @GetMapping("/authTree")
    public ResultMessage authTree(Token token) {
        return ResultMessage.ok(adminAuthBiz.authTree(token));
    }

    /**
     * 授权
     * @param adminCreditDto
     * @return
     */
    @PostMapping("/credit")
    public ResultMessage credit(@Valid @RequestBody AdminCreditDto adminCreditDto) {
        return ResultMessage.ok(adminAuthBiz.credit(adminCreditDto));
    }

    /**
     * 获取全部菜单树
     * @param token
     * @return
     */
    @GetMapping("/resList")
    public ResultMessage resList(Token token) {
        return ResultMessage.ok(adminAuthBiz.resList(token));
    }

}

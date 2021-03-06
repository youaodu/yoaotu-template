package com.youaotu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * * @time 2019-12-29 16:37
 */
@Data
public class AdminLoginDto {

    @NotBlank(message = "账号不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String pwd;

}

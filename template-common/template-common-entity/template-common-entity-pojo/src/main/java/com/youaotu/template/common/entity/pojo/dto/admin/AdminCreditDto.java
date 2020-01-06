package com.youaotu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AdminCreditDto {

    /**
     * 角色编号
     */
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    /**
     * 资源编号
     */
    @NotNull(message = "资源编号集不能为空")
    private List<Long> resIds;
}

package com.youaotu.template.common.entity.pojo.vo.admin;

import lombok.Data;

import java.util.List;

@Data
public class AdminResListVo {

    private Long id;

    private String name;

    private boolean check;

    private List<AdminResListVo> children;
}

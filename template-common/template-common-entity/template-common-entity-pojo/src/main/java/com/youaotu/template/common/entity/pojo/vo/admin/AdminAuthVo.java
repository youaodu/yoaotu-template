package com.youaotu.template.common.entity.pojo.vo.admin;

import lombok.Data;

import java.util.List;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 21:41
 */
@Data
public class AdminAuthVo {
    /**
     * 菜单名字
     */
    private String name;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 访问地址
     */
    private String path;

    /**
     * 是否显示
     */
    private Boolean hide;

    /**
     * 子集
     */
    private List<AdminAuthVo> children;
}

package com.youaotu.template.common.framework.crud;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * 支持用户实体自定义
 * 这里只包含了两个必要属性(用户名, 密码)
 */

@Data
@MappedSuperclass
public class BaseUser extends BaseEntity {
    private String userName;
    private String pwd;
}

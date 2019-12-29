package com.youaotu.template.common.entity.model;

import com.youaotu.template.common.framework.crud.BaseUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
public class AdminUser extends BaseUser {

    @Column(columnDefinition = "bit(1) DEFAULT b'0' COMMENT '该账号是否需要发验证码'")
    private boolean needSms;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '账号编号'")
    private String accountId;
}

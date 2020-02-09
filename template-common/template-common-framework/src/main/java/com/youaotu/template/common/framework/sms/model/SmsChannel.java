package com.youaotu.template.common.framework.sms.model;

import com.youaotu.template.common.framework.crud.BaseEntity;
import com.youaotu.template.common.framework.crud.Model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 短信通道
 */
@Data
@Entity
public class SmsChannel extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(30) COMMENT '通道标识'")
    private String channelCode;

    /**
     * 发短信账号
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '账号'")
    private String sendAccount;

    /**
     * 发短信密码
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '密码'")
    private String sendPwd;

    /**
     * 发送短信url
     */
    @Column(columnDefinition = "VARCHAR(200) COMMENT '发送URL'")
    private String sendUrl;

    /**
     * 批量发送短信url
     */
    @Column(columnDefinition = "VARCHAR(200) COMMENT '批量发送URL'")
    private String sendBatchUrl;
}

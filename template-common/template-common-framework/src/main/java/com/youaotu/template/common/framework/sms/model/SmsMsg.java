package com.youaotu.template.common.framework.sms.model;

import com.youaotu.template.common.framework.crud.BaseEntity;
import com.youaotu.template.common.framework.crud.Model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class SmsMsg extends BaseEntity {
    /**
     * 通道标识
     */
    @Column(columnDefinition = "varchar(20) COMMENT '通道标识'")
    private String channelCode;

    /**
     * 短信key
     */
    @Column(columnDefinition = "varchar(50) COMMENT '短信参数标识'")
    private String messageKey;

    /**
     * 短信模板
     */
    @Column(columnDefinition = "varchar(50) COMMENT '短信模板'")
    private String messageTemplate;
}

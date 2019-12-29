package com.youaotu.template.common.framework.token;

import lombok.Data;

@Data
public class Token {

    public Token(Long accountId, String accountName, String channelCode, String appCode) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.channelCode = channelCode;
        this.appCode = appCode;
        this.startTime = System.currentTimeMillis() / 1000;
        this.expire = 60 * 60 * 24 * 3L;
    }

    public Token() {
    }

    private Long accountId;

    private String accountName;

    private Long expire;

    private Long startTime;

    private String channelCode;

    private String appCode;
}

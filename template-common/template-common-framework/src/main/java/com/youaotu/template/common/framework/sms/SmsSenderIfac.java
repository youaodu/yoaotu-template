package com.youaotu.template.common.framework.sms;

import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

public interface SmsSenderIfac extends InitializingBean {
    void sendBasicMsg(String phone, String msg);

    void sendVarMsg(String phone, String msgKey, Map<String, Object> params);
}

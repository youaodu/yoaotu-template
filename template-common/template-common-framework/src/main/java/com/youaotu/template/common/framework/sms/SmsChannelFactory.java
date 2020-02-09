package com.youaotu.template.common.framework.sms;

import com.youaotu.template.common.framework.exception.BusinessException;
import com.youaotu.template.common.framework.utils.RedisUtils;
import com.youaotu.template.common.framework.utils.SpringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmsChannelFactory {

    /**
     * redis调用次数key
     */
    private static final String smsCountKey = "sms_channel_count";

    // redis
    private static RedisUtils redisUtils = SpringUtils.getBean(RedisUtils.class);

    private static List<SmsSenderIfac> factory = new ArrayList<>();

    public static void reg(SmsSenderIfac smsSenderIfac) {
        factory.add(smsSenderIfac);
    }

    public static SmsSenderIfac get() {
        // 只有一个通道 直接返回
        if (factory.size() == 1) {
            return factory.get(0);
        } else if (factory.size() == 0) {
            throw new BusinessException("没有可用短信通道");
        }

        Long count = redisUtils.getLong(smsCountKey);
        if (count == null) {
            redisUtils.set(smsCountKey, "1");
            count = 1L;
        }

        SmsSenderIfac smsSenderIfac = factory.get((int) (factory.size() % count));
        redisUtils.increment(smsCountKey, 1L);
        return smsSenderIfac;
    }

}
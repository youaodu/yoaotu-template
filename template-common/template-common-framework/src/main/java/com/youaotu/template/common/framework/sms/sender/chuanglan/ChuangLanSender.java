package com.youaotu.template.common.framework.sms.sender.chuanglan;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.youaotu.template.common.framework.exception.BusinessException;
import com.youaotu.template.common.framework.sms.SmsChannelFactory;
import com.youaotu.template.common.framework.sms.SmsSenderIfac;
import com.youaotu.template.common.framework.sms.model.SmsChannel;
import com.youaotu.template.common.framework.sms.model.SmsMsg;
import com.youaotu.template.common.framework.sms.repository.SmsChannelRepository;
import com.youaotu.template.common.framework.sms.repository.SmsMsgRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
public class ChuangLanSender implements SmsSenderIfac {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(ChuangLanSender.class);
    
    @Autowired
    private SmsMsgRepository smsMsgRepository;

    @Autowired
    private SmsChannelRepository smsChannelRepository;

    private SmsChannel sender;

    /**
     * 发送普通短信 >>> 此方法没有短信模板，因此message自带模板
     * @param phone > 手机号
     * @param msg > 短信信息
     */
    @Override
    public void sendBasicMsg(String phone, String msg) {
        if (StrUtil.isBlank(phone) || StrUtil.isBlank(msg)) {
            throw new BusinessException("发送普通短信参数为空");
        }

        ChuangLanRequest request = new ChuangLanRequest(sender.getSendAccount(), sender.getSendPwd(), msg, phone, "true");
        ChuangLanResponse response = JSONUtil.toBean(HttpUtil.post(sender.getSendUrl(), JSONUtil.toJsonStr(request)), ChuangLanResponse.class);

        if ("0".equals(response.getCode())) {
            logger.error("{}: 验证码发送失败 >>> {}", phone, JSONUtil.toJsonStr(response));
        }
    }

    @Override
    public void sendVarMsg(String phone, String msgKey, Map<String, Object> params) {
        logger.info("创蓝发送模板短信入参 >>> phone: {}, key: {}, params: {}", phone, params, new JSONObject(params).toString());
        if (StrUtil.isBlank(phone) || StrUtil.isBlank(phone) || MapUtil.isEmpty(params)) {
            throw new BusinessException("发送模板短信参数为空");
        }

        SmsMsg query = new SmsMsg();
        query.setChannelCode("chuanglan");
        query.setMessageKey(msgKey);
        SmsMsg msg = smsMsgRepository.findOne(Example.of(query)).get();
        for (Map.Entry<String, Object> it : params.entrySet()) {
            msg.setMessageTemplate(
                    msg.getMessageTemplate().replace(it.getKey(), it.getValue().toString())
            );
        }

        ChuangLanRequest request = new ChuangLanRequest(sender.getSendAccount(), sender.getSendPwd(), msg.getMessageTemplate(), phone, "true");
        ChuangLanResponse response = JSONUtil.toBean(HttpUtil.post(sender.getSendUrl(), JSONUtil.toJsonStr(request)), ChuangLanResponse.class);

        if ("0".equals(response.getCode())) {
            logger.error("{}: 验证码发送失败 >>> {}", phone, JSONUtil.toJsonStr(response));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 判断是否注册
        SmsChannel smsChannel = new SmsChannel();
        smsChannel.setChannelCode("chuanglan");

        try {
            smsChannel = smsChannelRepository.findOne(Example.of(smsChannel)).get();
        } catch (NoSuchElementException e) {
            smsChannel = null;
        }
        if (smsChannel != null) {
            SmsChannelFactory.reg(this);
            sender = smsChannel;
        }
    }
}

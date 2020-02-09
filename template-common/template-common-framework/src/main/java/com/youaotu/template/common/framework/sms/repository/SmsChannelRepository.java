package com.youaotu.template.common.framework.sms.repository;

import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.framework.sms.model.SmsChannel;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsChannelRepository extends CrudRepository<SmsChannel, Long> {

}

package com.youaotu.template.common.framework.sms.repository;

import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.framework.sms.model.SmsMsg;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsMsgRepository extends CrudRepository<SmsMsg, Long> {
}

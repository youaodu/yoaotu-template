package com.youaotu.template.common.dao;

import com.youaotu.template.common.entity.model.AdminAccount;
import com.youaotu.template.common.framework.crud.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @time 2019-12-29 16:59
 */
@Repository
public interface AdminAccountRepository extends CrudRepository<AdminAccount, Long> {
}

package com.youaotu.template.common.dao;

import com.youaotu.template.common.entity.model.AccountRole;
import com.youaotu.template.common.framework.crud.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:46
 */
@Repository
public interface AccountRoleRepository extends CrudRepository<AccountRole, Long> {
}

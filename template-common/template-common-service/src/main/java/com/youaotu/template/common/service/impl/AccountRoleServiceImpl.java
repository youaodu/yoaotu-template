package com.youaotu.template.common.service.impl;

import com.youaotu.template.common.dao.AccountRoleRepository;
import com.youaotu.template.common.entity.model.AccountRole;
import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:48
 */
@Service
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public CrudRepository<AccountRole, Long> getRepository() {
        return accountRoleRepository;
    }

}

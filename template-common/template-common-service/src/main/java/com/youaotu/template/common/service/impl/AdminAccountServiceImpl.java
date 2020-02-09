package com.youaotu.template.common.service.impl;

import com.youaotu.template.common.dao.AdminAccountRepository;
import com.youaotu.template.common.entity.model.AdminAccount;
import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @time 2019-12-29 17:05
 */
@Service
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    @Override
    public CrudRepository<AdminAccount, Long> getRepository() {
        return adminAccountRepository;
    }

}

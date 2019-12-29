package com.youaotu.template.common.service.impl;

import com.youaotu.template.common.dao.AdminUserRepository;
import com.youaotu.template.common.entity.model.AdminUser;
import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 17:05
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public CrudRepository<AdminUser, Long> getRepository() {
        return adminUserRepository;
    }

}

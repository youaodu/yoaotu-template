package com.youaotu.template.common.service;

import com.youaotu.template.common.dao.AdminUserRepository;
import com.youaotu.template.common.entity.model.AdminUser;
import com.youaotu.template.common.framework.crud.CrudService;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 17:03
 */
public interface AdminUserService extends CrudService<AdminUser, AdminUserRepository> {
}

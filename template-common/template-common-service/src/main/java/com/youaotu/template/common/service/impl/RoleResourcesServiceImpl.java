package com.youaotu.template.common.service.impl;

import com.youaotu.template.common.dao.RoleResourcesRepository;
import com.youaotu.template.common.entity.model.RoleResources;
import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.service.RoleResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:58
 */
@Service
public class RoleResourcesServiceImpl implements RoleResourcesService {

    @Autowired
    private RoleResourcesRepository roleResourcesRepository;

    @Override
    public CrudRepository<RoleResources, Long> getRepository() {
        return roleResourcesRepository;
    }
}

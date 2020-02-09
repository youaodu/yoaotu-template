package com.youaotu.template.common.service.impl;

import com.youaotu.template.common.dao.ResourcesRepository;
import com.youaotu.template.common.entity.model.Resources;
import com.youaotu.template.common.framework.crud.CrudRepository;
import com.youaotu.template.common.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @time 2019-12-29 23:53
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    @Override
    public CrudRepository<Resources, Long> getRepository() {
        return resourcesRepository;
    }
}

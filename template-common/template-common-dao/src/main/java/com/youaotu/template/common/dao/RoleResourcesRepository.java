package com.youaotu.template.common.dao;

import com.youaotu.template.common.entity.model.RoleResources;
import com.youaotu.template.common.framework.crud.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:57
 */
@Repository
public interface RoleResourcesRepository extends CrudRepository<RoleResources, Long> {
}

package com.youaotu.template.common.dao;

import com.youaotu.template.common.entity.model.Resources;
import com.youaotu.template.common.framework.crud.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @time 2019-12-29 23:52
 */
@Repository
public interface ResourcesRepository extends CrudRepository<Resources, Long> {
}

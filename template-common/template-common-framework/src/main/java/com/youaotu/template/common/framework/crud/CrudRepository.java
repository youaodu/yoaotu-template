package com.youaotu.template.common.framework.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CrudRepository<T extends Model, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
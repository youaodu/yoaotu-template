package com.youaotu.template.common.entity.model;

import com.youaotu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:38
 */
@Data
@Entity
public class RoleResources extends BaseEntity {

    @Column(columnDefinition = "BIGINT(10) COMMENT '角色编号'")
    public Long roleId;

    @Column(columnDefinition = "BIGINT(10) COMMENT '资源编号'")
    private Long resourcesId;
}

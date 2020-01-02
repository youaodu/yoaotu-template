package com.youaotu.template.common.entity.model;

import com.youaotu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 23:36
 */
@Data
@Entity
public class AccountRole extends BaseEntity {
    private String accountId;
    private Long roleId;
}

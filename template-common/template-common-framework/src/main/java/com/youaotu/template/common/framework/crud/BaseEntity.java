package com.youaotu.template.common.framework.crud;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'",insertable = false)
    private Date ctime;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'",updatable = false)
    private Date utime;

    @Column(columnDefinition = "TINYINT DEFAULT 0 COMMENT '逻辑删除'")
    private int deleted;
}

package com.youaotu.template.common.framework.http;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface RequestPage<T> {
    /**
     * 分页起始索引
     * @return
     */
    Integer getPageNum();

    /**
     * 分页结束索引大小
     * @return
     */
    Integer getPageSize();

    T getModel();

    default Specification<T> getSpecification() {
        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                T model = getModel();
                Class<?> modelClass = model.getClass();

                Field[] fields = ReflectUtil.getFields(modelClass);
                for (Field field : fields) {
                    // 获取实体值
                    Object params = ReflectUtil.getFieldValue(model, field);
                    if (params != null) {
                        list.add(criteriaBuilder.equal(root.get(field.getName()), params));
                    }
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };

        return specification;
    }
}
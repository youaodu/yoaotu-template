package com.youaotu.template.common.framework.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @create 2019-09-05 23:16
 */
public class ConvertUtils {

    /**
     * 转换Bean
     *
     * @time 23:19
     * @param bean
     * @param tClass
     */
    public static <T> T convertBean(Object bean, Class<T> tClass) {
        if (bean == null) {
            return null;
        }
        try {
            T t = tClass.newInstance();
            BeanUtil.copyProperties(bean, t);
            return t;
        } catch (Exception e) {
           return null;
        }
    }

    public static <T> List<T> convertList(Collection<Object> beans, Class<T> tClass) {
        if (CollectionUtil.isEmpty(beans) || tClass == null) {
            return new ArrayList<>();
        }

        List<T> collect = beans.stream().map(it -> {
            try {
                T t = tClass.newInstance();
                BeanUtil.copyProperties(it, t);
                return t;
            } catch (Exception e) {
                return null;
            }
        }).collect(Collectors.toList());

        return collect;
    }
}

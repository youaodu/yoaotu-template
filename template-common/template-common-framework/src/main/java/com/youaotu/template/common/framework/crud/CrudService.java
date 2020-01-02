package com.youaotu.template.common.framework.crud;

import com.youaotu.template.common.framework.http.RequestPage;
import com.youaotu.template.common.framework.http.ResultPage;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public interface CrudService<T extends Model, R extends CrudRepository> {

    CrudRepository<T, Long> getRepository();

    default List<T> findList(T t) {
        return getRepository().findAll(Example.of(t));
    }

    /**
     * 分页查询
     * @param request
     * @param <Q>
     * @return
     */
    default <Q extends RequestPage> ResultPage<T> findPage(Q request) {
        Specification<T> specification = request.getSpecification();
        Pageable pageable = PageRequest.of(request.getPageNum() - 1, request.getPageSize(), Sort.by(Sort.Order.desc("id")));
        Page all = getRepository().findAll(specification, pageable);
        ResultPage<T> result = new ResultPage<>();
        result.setList(all.getContent());
        result.setTotal(all.getTotalElements());
        return result;
    }

    /**
     * 根据某些条件精确查询
     * @param t
     * @return
     */
    default List<T> findAll(T t) {
        if (t != null) {
            return getRepository().findAll(Example.of(t));
        }
        return null;
    }

    /**
     * 没有任何条件查询
     * @return
     */
    default List<T> findAll() {
        return getRepository().findAll();
    }

    /**
     * 获取单个
     * @param t
     * @return
     */
    default T findOne(T t) {
        try {
            return getRepository().findOne(Example.of(t)).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    default T update(T t) {
        T save = getRepository().saveAndFlush(t);
        return save;
    }

    default void delete(T t) {
        getRepository().delete(t);
    }

    /**
     * 求count
     * @param t
     * @return
     */
    default long count(T t) {
        return getRepository().count(Example.of(t));
    }

    default List<T> findListByIds(Collection<Long> ids) {
        return getRepository().findAllById(ids);
    }

}

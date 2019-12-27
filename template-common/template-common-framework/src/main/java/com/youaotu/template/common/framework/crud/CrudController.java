package com.youaotu.template.common.framework.crud;

import com.youaotu.template.common.framework.http.RequestPage;
import com.youaotu.template.common.framework.http.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudController<T extends Model, S extends CrudService> {

    S getCrudService();

    @GetMapping("/page")
    default <Q extends RequestPage> ResultMessage findByPage(Q request) {
        S crudService = getCrudService();
        return ResultMessage.ok(crudService.findPage(request));
    }


    @GetMapping("/templateAll")
    default ResultMessage findAll(T t) {
        S crudService = getCrudService();
        return ResultMessage.ok(crudService.findAll(t));
    }

    @GetMapping("/list")
    default ResultMessage findAll() {
        return ResultMessage.ok(getCrudService().findAll());
    }

    @GetMapping("/findOne")
    default ResultMessage findOne(T t) {
        return ResultMessage.ok(getCrudService().findOne(t));
    }

    @PostMapping("/saveOrUpdate")
    default ResultMessage save(@RequestBody T t) {
        return ResultMessage.ok(getCrudService().update(t));
    }

    @PostMapping
    default ResultMessage delete(@RequestBody T t) {
        getCrudService().delete(t);
        return ResultMessage.ok();
    }
}

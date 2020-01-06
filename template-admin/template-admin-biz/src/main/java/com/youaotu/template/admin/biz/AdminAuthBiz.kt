package com.youaotu.template.admin.biz

import com.youaotu.template.common.entity.pojo.dto.admin.AdminCreditDto
import com.youaotu.template.common.entity.pojo.vo.admin.AdminAuthVo
import com.youaotu.template.common.entity.pojo.vo.admin.AdminResListVo
import com.youaotu.template.common.framework.token.Token

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 21:40
 */
interface AdminAuthBiz {

    /**
     * 权限树
     */
    fun authTree(token: Token): MutableList<AdminAuthVo>

    /**
     * 授权
     */
    fun credit(adminCreditDto: AdminCreditDto): Int

    /**
     * 获取全部数据库
     */
    fun resList(token: Token): MutableList<AdminResListVo>
}
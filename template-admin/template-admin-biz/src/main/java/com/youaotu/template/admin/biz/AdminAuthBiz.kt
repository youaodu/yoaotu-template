package com.youaotu.template.admin.biz

import com.youaotu.template.common.entity.pojo.vo.admin.AdminAuthVo
import com.youaotu.template.common.framework.token.Token

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 21:40
 */
interface AdminAuthBiz {
    fun authTree(token: Token): MutableList<AdminAuthVo>
}
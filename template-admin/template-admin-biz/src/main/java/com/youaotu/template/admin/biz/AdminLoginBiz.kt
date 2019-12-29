package com.youaotu.template.admin.biz

import com.youaotu.template.common.entity.pojo.dto.admin.AdminLoginDto
import com.youaotu.template.common.entity.pojo.vo.admin.AdminLoginVo


/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 16:39
 */
interface AdminLoginBiz {
    fun login(adminLoginDto: AdminLoginDto): AdminLoginVo

}
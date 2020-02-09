package com.youaotu.template.admin.biz.impl

import cn.hutool.core.bean.BeanUtil
import cn.hutool.json.JSONUtil
import com.youaotu.template.admin.biz.AdminLoginBiz
import com.youaotu.template.common.entity.model.AdminAccount
import com.youaotu.template.common.entity.pojo.dto.admin.AdminLoginDto
import com.youaotu.template.common.entity.pojo.vo.admin.AdminLoginVo
import com.youaotu.template.common.framework.exception.BusinessException
import com.youaotu.template.common.framework.token.BuilderToken
import com.youaotu.template.common.framework.token.Token
import com.youaotu.template.common.service.AdminAccountService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * * @time 2019-12-29 16:40
 */
@Service
class AdminLoginBizImpl: AdminLoginBiz {

    val logger = LoggerFactory.getLogger(AdminLoginBizImpl::class.java)

    @Autowired
    lateinit var adminAccountService: AdminAccountService

    /**
     * 登录
     */
    override fun login(adminLoginDto: AdminLoginDto): AdminLoginVo {
        logger.info("后台登录入参 >>> {}", JSONUtil.toJsonStr(adminLoginDto))
        var adminUser = AdminAccount()
        BeanUtil.copyProperties(adminLoginDto, adminUser)

        // 校验账号名是否存在
        val count = adminAccountService.count(adminUser)
        if (count == 0L) {
            throw BusinessException("账号或密码错误")
        }

        val user = adminAccountService.findOne(adminUser)

        // 构建 token 对象
        val tokenBean = Token()
        tokenBean.accountId = user.accountId
        tokenBean.appCode = "admin"
        tokenBean.accountName = user.userName
        // 生成token
        val tokenStr = BuilderToken.builderToken(tokenBean)

        val result = AdminLoginVo()
        result.token = tokenStr

        return result
    }

}
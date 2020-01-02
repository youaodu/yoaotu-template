package com.youaotu.template.admin.biz.impl

import com.youaotu.template.admin.biz.AdminAuthBiz
import com.youaotu.template.common.entity.model.AccountRole
import com.youaotu.template.common.entity.model.Resources
import com.youaotu.template.common.entity.model.RoleResources
import com.youaotu.template.common.entity.pojo.vo.admin.AdminAuthVo
import com.youaotu.template.common.framework.token.Token
import com.youaotu.template.common.service.AccountRoleService
import com.youaotu.template.common.service.ResourcesService
import com.youaotu.template.common.service.RoleResourcesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * @author youao.du@gmail.com
 * @time 2019-12-30 21:40
 */
@Service
class AdminAuthBizImpl: AdminAuthBiz {

    @Autowired
    lateinit var roleResourcesService: RoleResourcesService

    @Autowired
    lateinit var accountRoleService: AccountRoleService

    @Autowired
    lateinit var resourcesService: ResourcesService

    /**
     * 获取权限树
     */
    override fun authTree(token: Token): MutableList<AdminAuthVo> {
        val roleIds = accountRoleService.findAll().stream().map(AccountRole::getRoleId).collect(Collectors.toList())

        // 最后的资源列表
        val resources: MutableList<Resources> = mutableListOf()
        roleIds.forEach {
            // 获取该角色下所有资源信息
            val queryBean = RoleResources()
            queryBean.roleId = it
            // 获取所有资源Id列表
            val resIds = roleResourcesService.findList(queryBean).stream().map(RoleResources::getResourcesId).collect(Collectors.toList())
            // 获取所有资源信息
            val resList: MutableList<Resources> = resourcesService.findListByIds(resIds)
            resources.addAll(resList)
        }

        return genTree(resources.listIterator(), 0L)
    }

    private fun genTree(list: MutableIterator<Resources>, pid: Long): MutableList<AdminAuthVo> {
        val result: MutableList<AdminAuthVo> = mutableListOf()
        while (list.hasNext()) {
            val it = list.next()
            // 排除当前索引
            list.remove()

            // 组装返回Item
            val resultItem = AdminAuthVo()
            resultItem.component = it.component
            resultItem.hide = it.hide
            resultItem.name = it.name
            resultItem.path = it.path
            // 递归 设置子集
            resultItem.children = genTree(list, it.id)

            result.add(resultItem)
        }
        return result
    }

}
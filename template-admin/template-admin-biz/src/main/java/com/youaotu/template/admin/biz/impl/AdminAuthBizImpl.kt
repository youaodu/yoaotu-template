package com.youaotu.template.admin.biz.impl

import com.youaotu.template.admin.biz.AdminAuthBiz
import com.youaotu.template.common.entity.model.AccountRole
import com.youaotu.template.common.entity.model.Resources
import com.youaotu.template.common.entity.model.RoleResources
import com.youaotu.template.common.entity.pojo.dto.admin.AdminCreditDto
import com.youaotu.template.common.entity.pojo.vo.admin.AdminAuthVo
import com.youaotu.template.common.entity.pojo.vo.admin.AdminResListVo
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
open class AdminAuthBizImpl: AdminAuthBiz {

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

    /**
     * 授权
     */
    override fun credit(adminCreditDto: AdminCreditDto): Int {
        val creditList: MutableList<RoleResources> = adminCreditDto.resIds.map {
            val saveBean = RoleResources()
            // 单个参数
            saveBean.resourcesId = it
            saveBean.roleId = adminCreditDto.roleId

            // 返回对象
            saveBean
        }.toMutableList()

        roleResourcesService.saveOrUpdateBatch(creditList)
        return 1
    }

    /**
     * 获取整个资源集合
     */
    override fun resList(token: Token): MutableList<AdminResListVo> {
        val query = AccountRole()
        query.accountId = token.accountId

        // 获取所有的角色
        val roleIds = accountRoleService.findList(query).map { it.roleId }.toMutableList()
        return showResList(0, roleIds)
    }

    private fun showResList(pid: Long, roleId: List<Long>):MutableList<AdminResListVo> {
        val query: Resources = Resources()
        query.pid = pid
        val findAll = resourcesService.findAll(query)
        val toMutableList = findAll.map {
            val resultItem = AdminResListVo()
            resultItem.id = it.id
            resultItem.name = it.name

            // 判断选中状态
            roleId.forEach {
                val queryRoleHas = RoleResources()
                queryRoleHas.roleId = it
                queryRoleHas.resourcesId = resultItem.id
                val count = roleResourcesService.count(queryRoleHas)
                // 有权限
                if (count > 0) {
                    // 更改选中状态
                    resultItem.isCheck = true
                }
            }
            resultItem.children = showResList(it.id, roleId)
            resultItem
        }.toMutableList()

        return toMutableList
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

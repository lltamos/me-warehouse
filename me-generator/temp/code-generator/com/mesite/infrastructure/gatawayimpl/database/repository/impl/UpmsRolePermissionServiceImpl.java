package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsRolePermission;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsRolePermissionMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsRolePermissionServiceImpl extends ServiceImpl<IUpmsRolePermissionMapper, UpmsRolePermission> implements UpmsRolePermissionService {

}

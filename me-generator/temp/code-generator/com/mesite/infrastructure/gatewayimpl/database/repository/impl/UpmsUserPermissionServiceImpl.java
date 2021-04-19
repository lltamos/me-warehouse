package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsUserPermission;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsUserPermissionMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限关联表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsUserPermissionServiceImpl extends ServiceImpl<IUpmsUserPermissionMapper, UpmsUserPermission> implements UpmsUserPermissionService {

}

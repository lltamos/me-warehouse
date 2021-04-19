package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsPermission;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsPermissionMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsPermissionServiceImpl extends ServiceImpl<IUpmsPermissionMapper, UpmsPermission> implements UpmsPermissionService {

}

package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsUserRole;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsUserRoleMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsUserRoleServiceImpl extends ServiceImpl<IUpmsUserRoleMapper, UpmsUserRole> implements UpmsUserRoleService {

}

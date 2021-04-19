package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsRole;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsRoleMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsRoleServiceImpl extends ServiceImpl<IUpmsRoleMapper, UpmsRole> implements UpmsRoleService {

}

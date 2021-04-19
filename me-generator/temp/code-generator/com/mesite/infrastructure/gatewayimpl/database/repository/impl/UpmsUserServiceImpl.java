package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsUser;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsUserMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsUserServiceImpl extends ServiceImpl<IUpmsUserMapper, UpmsUser> implements UpmsUserService {

}

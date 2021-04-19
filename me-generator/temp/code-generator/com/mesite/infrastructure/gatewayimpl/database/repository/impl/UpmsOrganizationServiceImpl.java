package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsOrganization;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsOrganizationMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsOrganizationServiceImpl extends ServiceImpl<IUpmsOrganizationMapper, UpmsOrganization> implements UpmsOrganizationService {

}

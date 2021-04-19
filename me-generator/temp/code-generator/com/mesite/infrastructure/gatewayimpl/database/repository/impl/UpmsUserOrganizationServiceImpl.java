package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsUserOrganization;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsUserOrganizationMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsUserOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组织关联表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsUserOrganizationServiceImpl extends ServiceImpl<IUpmsUserOrganizationMapper, UpmsUserOrganization> implements UpmsUserOrganizationService {

}

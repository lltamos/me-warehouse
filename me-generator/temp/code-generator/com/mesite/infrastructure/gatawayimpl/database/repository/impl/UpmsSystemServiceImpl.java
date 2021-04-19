package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsSystem;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsSystemMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsSystemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsSystemServiceImpl extends ServiceImpl<IUpmsSystemMapper, UpmsSystem> implements UpmsSystemService {

}

package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.UpmsLog;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IUpmsLogMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.UpmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class UpmsLogServiceImpl extends ServiceImpl<IUpmsLogMapper, UpmsLog> implements UpmsLogService {

}

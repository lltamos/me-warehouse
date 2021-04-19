package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.FClass;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IFClassMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.FClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class FClassServiceImpl extends ServiceImpl<IFClassMapper, FClass> implements FClassService {

}

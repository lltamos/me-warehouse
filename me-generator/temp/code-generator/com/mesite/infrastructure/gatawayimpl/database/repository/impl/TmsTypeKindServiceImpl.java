package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeKind;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTypeKindMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTypeKindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学院-项目-专业/专业等级分类表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTypeKindServiceImpl extends ServiceImpl<ITmsTypeKindMapper, TmsTypeKind> implements TmsTypeKindService {

}

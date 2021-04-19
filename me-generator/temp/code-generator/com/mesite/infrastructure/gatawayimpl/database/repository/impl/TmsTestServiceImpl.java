package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试题表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestServiceImpl extends ServiceImpl<ITmsTestMapper, TmsTest> implements TmsTestService {

}

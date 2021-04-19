package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestChild;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestChildMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTestChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 子试题表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestChildServiceImpl extends ServiceImpl<ITmsTestChildMapper, TmsTestChild> implements TmsTestChildService {

}

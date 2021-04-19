package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPackage;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPackageMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTestPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试卷包 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestPackageServiceImpl extends ServiceImpl<ITmsTestPackageMapper, TmsTestPackage> implements TmsTestPackageService {

}

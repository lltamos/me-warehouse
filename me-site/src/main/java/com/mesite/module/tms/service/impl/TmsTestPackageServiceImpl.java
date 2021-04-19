package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPackage;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPackageMapper;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestPackageVo;
import com.mesite.module.tms.service.TmsTestPackageService;
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

    @Override
    public boolean createAndUpdate(TmsTestPackageVo tmsTestPackageVo) {
        return false;
    }

    @Override
    public BasePage<TmsTestPackageVo> findTestPackageLists(TmsSearchBo tmsSearchBo) {
        return null;
    }
}

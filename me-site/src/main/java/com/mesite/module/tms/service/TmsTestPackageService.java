package com.mesite.module.tms.service;

import com.mesite.domain.common.BasePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPackage;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestPackageVo;

/**
 * <p>
 * 试卷包 服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface TmsTestPackageService extends IService<TmsTestPackage> {

    boolean createAndUpdate(TmsTestPackageVo tmsTestPackageVo);

    BasePage<TmsTestPackageVo> findTestPackageLists(TmsSearchBo tmsSearchBo);
}

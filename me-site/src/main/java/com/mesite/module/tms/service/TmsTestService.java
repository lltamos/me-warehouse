package com.mesite.module.tms.service;

import com.mesite.domain.common.BasePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestVo;

/**
 * <p>
 * 试题表 服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface TmsTestService extends IService<TmsTest> {
    boolean createAndUpdate(TmsTestVo tmsTestVo);

    BasePage<TmsTestVo> findTestLists(TmsSearchBo tmsSearchBo);
}

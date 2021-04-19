package com.mesite.module.tms.service;

import com.mesite.domain.common.BasePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPager;
import com.mesite.module.tms.entity.PaperViewBo;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestPagerVo;

/**
 * <p>
 * 试卷 服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface TmsTestPagerService extends IService<TmsTestPager> {
    BasePage<TmsTestPager> findTestPagerLists(TmsSearchBo tmsSearchBo);
     boolean createAndUpdate(TmsTestPagerVo tmsTestPagerVo);
     PaperViewBo paper(Integer id);
}

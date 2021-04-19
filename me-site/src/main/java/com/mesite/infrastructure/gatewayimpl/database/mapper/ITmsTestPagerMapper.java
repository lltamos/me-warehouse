package com.mesite.infrastructure.gatewayimpl.database.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mesite.module.tms.entity.TmsTestVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 试卷 Mapper 接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface ITmsTestPagerMapper extends BaseMapper<TmsTestPager> {

    BasePage<TmsTestPager> findTmsTestPapers(
            @Param("tmsKindTypeId") Integer tmsKindTypeId,
            @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
            @Param("title") String title,
            IPage<TmsTestPager> basePage);
}

package com.mesite.infrastructure.gatewayimpl.database.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPackage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 试卷包 Mapper 接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface ITmsTestPackageMapper extends BaseMapper<TmsTestPackage> {
    BasePage<TmsTestPackage> findTmsTestPackage(@Param("tmsKindTypeId") Integer tmsKindTypeId,
                                                  @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
                                                  @Param("title") String title,
                                                  IPage<TmsTestPackage> basePage);
}

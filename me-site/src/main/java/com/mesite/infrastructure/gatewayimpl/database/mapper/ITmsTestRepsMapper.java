package com.mesite.infrastructure.gatewayimpl.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestReps;
import com.mesite.module.tms.entity.TmsTestRepsVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 试题库 Mapper 接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface ITmsTestRepsMapper extends BaseMapper<TmsTestReps> {

    BasePage<TmsTestRepsVo> findPageByLockedAndName(IPage<TmsTestReps> page, @Param("locked") Integer locked, @Param("key") String key);


    /**
     *
     * @param id 试题库ID
     * @return
     */
    TmsTestRepsVo countByTmsTestRepsIdAndTxIdAll(@Param("id") Long id);
}

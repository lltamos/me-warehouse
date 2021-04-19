package com.mesite.infrastructure.gatewayimpl.database.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mesite.domain.common.BasePage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.module.tms.entity.TmsTestVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 试题表 Mapper 接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface ITmsTestMapper extends BaseMapper<TmsTest> {
    BasePage<TmsTestVo> findByTmsTestRepsIdAndTxIdTiGanLike(@Param("tmsTestRepsId") Integer tmsTestRepsId,
                                                            @Param("txId") Integer txId,
                                                            @Param("tiGan") String tiGan,
                                                            IPage<TmsTest> basePage);
}

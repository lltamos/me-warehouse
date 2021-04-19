package com.mesite.infrastructure.gatewayimpl.database.mapper;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperPackageShip;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 试题和试卷的关联关系 Mapper 接口
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface ITmsTestPaperShipMapper extends BaseMapper<TmsTestPaperShip> {
    List<TmsTestPaperShip> findTmsPaperIdOrderByRank(@Param("tmsTestPaperId") Integer tmsTestPaperId);
}

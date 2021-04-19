package com.mesite.module.tms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;

import java.util.List;

/**
 * <p>
 * 试题和试卷的关联关系 服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface TmsTestPaperShipService extends IService<TmsTestPaperShip> {
    List<TmsTestPaperShip> findTmsPaperIdOrderByRank(Integer tmsTestPaperId);

}

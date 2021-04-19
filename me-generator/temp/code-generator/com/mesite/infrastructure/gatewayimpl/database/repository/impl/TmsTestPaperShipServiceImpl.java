package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPaperShipMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTestPaperShipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试题和试卷的关联关系 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestPaperShipServiceImpl extends ServiceImpl<ITmsTestPaperShipMapper, TmsTestPaperShip> implements TmsTestPaperShipService {

}

package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperPackageShip;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPaperPackageShipMapper;
import com.mesite.module.tms.service.TmsTestPaperPackageShipService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试卷包和试卷的绑定关系 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestPaperPackageShipServiceImpl extends ServiceImpl<ITmsTestPaperPackageShipMapper, TmsTestPaperPackageShip> implements TmsTestPaperPackageShipService {

}

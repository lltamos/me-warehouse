package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPaperShipMapper;
import com.mesite.module.tms.service.TmsTestPaperShipService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<TmsTestPaperShip> findTmsPaperIdOrderByRank(Integer tmsTestPaperId) {
        return getBaseMapper().findTmsPaperIdOrderByRank(tmsTestPaperId);
    }
}

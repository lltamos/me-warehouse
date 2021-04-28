package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.common.validator.Assert;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestMapper;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestVo;
import com.mesite.module.tms.enums.QuestionEnum;
import com.mesite.module.tms.service.TmsTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <p>
 * 试题表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestServiceImpl extends ServiceImpl<ITmsTestMapper, TmsTest> implements TmsTestService {


    @Transactional
    public boolean createAndUpdate(TmsTestVo tmsTestVo) {
        Assert.isNull(tmsTestVo);
        return saveOrUpdate(tmsTestVo);
    }

    public BasePage<TmsTestVo> findTestLists(TmsSearchBo tmsSearchBo) {

        TmsSearchBo tmsSearchBoPre = Optional.ofNullable(tmsSearchBo).orElse(new TmsSearchBo());
        BasePage<TmsTestVo> tmsTestVoBasePage = getBaseMapper().findByTmsTestRepsIdAndTxIdTiGanLike(tmsSearchBoPre.getTestRepsId(),
                tmsSearchBoPre.getTxid(),
                tmsSearchBoPre.getKey(),
                tmsSearchBoPre.parse());
        TmsTestVo tmsTestVo = tmsTestVoBasePage.getList().get(0);
        return tmsTestVoBasePage.copy(item -> {
            item.setTxStr(QuestionEnum.getVal(item.getTxId()));
            return item;
        });

    }

    @Override
    public TmsTestVo detail(Integer tmsTestId) {
        return TmsTestVo.covert(this.getById(tmsTestId));
    }

    @Transactional
    public boolean delete(Integer tmsTestId) {
        return removeById(tmsTestId);
    }


}

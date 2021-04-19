package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestReps;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestRepsMapper;
import com.mesite.module.tms.entity.TmsTestRepsVo;
import com.mesite.module.tms.service.TmsTestRepsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

/**
 * <p>
 * 试题库 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTestRepsServiceImpl extends ServiceImpl<ITmsTestRepsMapper, TmsTestReps> implements TmsTestRepsService {


    @Transactional
    public boolean createQuestionReps(TmsTestRepsVo tmsQuestionRepsVo) {
        this.save(tmsQuestionRepsVo);
        return true;
    }


    public BasePage<TmsTestRepsVo> findTestRepsLists(Integer page, Integer limit, String key) {
        BasePage<TmsTestRepsVo> repsBasePage = getBaseMapper().findPageByLockedAndName(new BasePage<>(page, limit), 1, key);
        repsBasePage.getList().stream().peek(item -> {
            TmsTestRepsVo tmsTestRepsVo = getBaseMapper().countByTmsTestRepsIdAndTxIdAll(item.getId());
            item.setSingleChoice(tmsTestRepsVo.getSingleChoice());
            item.setMultipleChoice(tmsTestRepsVo.getMultipleChoice());
            item.setVerdict(tmsTestRepsVo.getVerdict());
            item.setInterpose(tmsTestRepsVo.getInterpose());
            item.setShortAnswer(tmsTestRepsVo.getShortAnswer());
            item.setGroupQuestion(tmsTestRepsVo.getGroupQuestion());
            item.setTotalQuestion(tmsTestRepsVo.getTotalQuestion());
        }).collect(Collectors.toList());
        return repsBasePage;
    }
}

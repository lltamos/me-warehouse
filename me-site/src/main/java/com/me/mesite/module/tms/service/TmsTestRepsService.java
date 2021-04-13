package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.domain.common.BasePage;
import com.me.mesite.domain.vo.TmsTestRepsVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestReps;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestRepsRepository;
import com.me.mesite.module.Idds.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Slf4j
public class TmsTestRepsService {

    @Resource
    private TmsTestRepsRepository tmsTestRepsRepository;

    @Resource
    private TmsTestRepository tmsTestRepository;

    @Transactional
    public boolean createQuestionReps(TmsTestRepsVo tmsQuestionRepsVo) {
        tmsTestRepsRepository.save((TmsTestReps) tmsQuestionRepsVo);
        return true;
    }


    public Page<TmsTestRepsVo> findTestRepsLists(Integer page, Integer limit, String key) {

        Page<TmsTestReps> tmsTestReps;
        Page<TmsTestRepsVo> tmsTestRepsVos;

        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));

        if (StringUtils.isEmpty(key)) {
            tmsTestReps = tmsTestRepsRepository.findAllByLocked(1, pageable);
        } else {
            tmsTestReps = tmsTestRepsRepository.findAllByLockedAndNameStartsWith(1, key, pageable);
        }

        tmsTestRepsVos = tmsTestReps.map(item -> {
            log.info("classname：{}", item.getClass().getName());
            int countAll = tmsTestRepository.countByTmsTestRepsId(item.getId());
            int tx0 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 0);
            int tx1 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 1);
            int tx2 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 2);
            int tx3 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 3);
            int tx4 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 4);
            int tx5 = tmsTestRepository.countByTmsTestRepsIdAndTxId(item.getId(), 5);
            TmsTestRepsVo tvo = new TmsTestRepsVo();
            BeanUtils.copyProperties(item, tvo);
            tvo.setTotalQuestion(countAll);
            tvo.setSingleChoice(tx0);
            tvo.setMultipleChoice(tx1);
            tvo.setVerdict(tx2);
            tvo.setInterpose(tx3);
            tvo.setShortAnswer(tx4);
            tvo.setGroupQuestion(tx5);
            return tvo;
        });
        return tmsTestRepsVos;
    }


}

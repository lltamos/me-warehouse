package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepsRepository;
import com.me.mesite.module.Idds.config.Constant;
import com.me.mesite.domain.vo.TmsQuestionRepsVo;
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
public class TmsQuestionTestRepsService {

    @Resource
    private TmsQuestionRepsRepository tmsQuestionRepsRepository;

    @Resource
    private TmsQuestionRepository tmsQuestionRepository;

    @Transactional
    public boolean createQuestionReps(TmsQuestionRepsVo tmsQuestionRepsVo) {
        tmsQuestionRepsRepository.save((TmsQuestionReps) tmsQuestionRepsVo);
        return true;
    }


    public Page<TmsQuestionRepsVo> findQuestionRepsLists(Integer page, Integer limit, String key) {

        Page<TmsQuestionReps> tmsQuestionReps;
        Page<TmsQuestionRepsVo> tmsQuestionRepsVos;


        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));

        if (StringUtils.isEmpty(key)) {
            tmsQuestionReps = tmsQuestionRepsRepository.findAll(pageable);
        } else {
            tmsQuestionReps = tmsQuestionRepsRepository.findTmsQuestionRepsByNameStartsWith(key, pageable);
        }

        tmsQuestionRepsVos = tmsQuestionReps.map(item -> {
            log.info("classname：{}", item.getClass().getName());
            int countAll = tmsQuestionRepository.countByTmsQuestionRepsId(item.getId());
            int tx0 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 0);
            int tx1 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 1);
            int tx2 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 2);
            int tx3 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 3);
            int tx4 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 4);
            int tx5 = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(item.getId(), 5);
            TmsQuestionRepsVo tvo = new TmsQuestionRepsVo();
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

        return tmsQuestionRepsVos;
    }


}

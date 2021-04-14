package com.me.mesite.module.tms.service;

import cn.hutool.core.lang.Tuple;
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
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        long l = System.currentTimeMillis();
        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));
        if (StringUtils.isEmpty(key)) {
            key = "";
        }
        Page<TmsTestReps> tmsTestReps = tmsTestRepsRepository.findAllByLockedAndNameStartsWith(1, key, pageable);
        Page<TmsTestRepsVo> tmsTestRepsVos = tmsTestReps.map(item -> {
            List<Map<Integer, Object>> mapList = tmsTestRepository.countByTmsTestRepsIdAndTxIdAll(item.getId());
            TmsTestRepsVo tvo = new TmsTestRepsVo();
            BeanUtils.copyProperties(item, tvo);
            mapList.forEach(imap -> {
                Integer tx = (Integer) imap.get("tx");
                BigInteger num = (BigInteger) imap.get("num");
                tvo.parseRepsTestData(tx, num.intValue());
            });
            tvo.setTotalQuestion();
            return tvo;
        });
        System.out.println((System.currentTimeMillis() - l) / 1000);
        return tmsTestRepsVos;
    }


}

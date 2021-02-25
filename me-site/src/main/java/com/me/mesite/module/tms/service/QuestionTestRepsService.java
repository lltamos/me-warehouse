package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepsRepository;
import com.me.mesite.module.Idds.config.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionTestRepsService {

    @Resource
    private TmsQuestionRepsRepository tmsQuestionRepsRepository;

    public Page<TmsQuestionReps> findQuestionRepsLists(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));
        return StringUtils.isEmpty(key) ? tmsQuestionRepsRepository.findAll(pageable) : tmsQuestionRepsRepository.findTmsQuestionRepsByNameStartsWith(key, pageable);
    }
}

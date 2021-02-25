package com.me.mesite.module.tms.service;

import cn.hutool.core.map.MapUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.me.mesite.common.utils.MapUtils;
import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsKindType;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsKindTypeRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepsRepository;
import com.me.mesite.module.Idds.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsFileConstantService {

    //获取项目下的学院名称
    Map<Integer, TmsKindType> tmsKindTypeCache = null;

    @Resource
    private TmsKindTypeRepository tmsKindTypeRepository;

    public TmsKindType getKindType(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (tmsKindTypeCache.isEmpty()) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            init();
        }
        return tmsKindTypeCache.get(kinId);
    }


    @PostConstruct
    void init() {
        tmsKindTypeCache = null;
        tmsKindTypeCache = Maps.newHashMap();
        List<TmsKindType> tmsKindTypes = tmsKindTypeRepository.findAll();
        tmsKindTypeCache = tmsKindTypes.stream().collect(Collectors.toMap(TmsKindType::getId, x1 -> x1));
    }

}

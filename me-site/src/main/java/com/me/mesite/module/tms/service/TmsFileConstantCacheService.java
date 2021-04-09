package com.me.mesite.module.tms.service;

import com.google.common.collect.Maps;
import com.me.mesite.common.utils.Tools;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeKind;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeSubject;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTypeCourseRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTypeKindRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTypeSubjectRepository;
import com.me.mesite.module.tms.event.RefreshMsgEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsFileConstantCacheService {

    //获取项目下的学院名称
    private final String tmsKindTypeCacheName = "tmsKindTypeCache";
    private final String tmsSubjectTypeCacheName = "tmsSubjectTypeCache";

    private Map<String, Map<Integer, Object>> cache = Maps.newHashMap();

    @Resource
    private TmsTypeKindRepository tmsTypeKindRepository;
    @Resource
    private TmsTypeCourseRepository tmsTypeCourseRepository;
    @Resource
    private TmsTypeSubjectRepository tmsTypeSubjectRepository;

    public TmsTypeKind getTypeKind(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (Tools.isEmpty(cache)) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            this.init();
        }
        Map<Integer, Object> tmsKindTypeCacheMap = cache.get(tmsKindTypeCacheName);
        return (TmsTypeKind) tmsKindTypeCacheMap.get(kinId);
    }

    @PostConstruct
    private void init() {
        cache.clear();
        //缓存项目分类信息
        List<TmsTypeKind> tmsKindTypes = tmsTypeKindRepository.findAll();
        Map<Integer, Object> tmsKindTypeCacheMap = tmsKindTypes.stream().collect(Collectors.toMap(TmsTypeKind::getId, x1 -> x1));
        cache.put(tmsKindTypeCacheName, tmsKindTypeCacheMap);
        //缓存项目信息
        List<TmsTypeSubject> tmsSubjectTypes = tmsTypeSubjectRepository.findAll();
        Map<Integer, Object> tmsSubjectTypesCacheMap = tmsSubjectTypes.stream().collect(Collectors.toMap(TmsTypeSubject::getId, x1 -> x1));
        cache.put(tmsSubjectTypeCacheName, tmsSubjectTypesCacheMap);
        log.info("system db ContactCache write TmsKindType:{} tmsSubjectTypes{},success", tmsKindTypeCacheMap, tmsSubjectTypesCacheMap);

    }


    @EventListener(classes = RefreshMsgEvent.class)
    public void handleRefreshMsgEvent(RefreshMsgEvent event) {
        log.info("RefreshMsgEvent execute refresh ,type:{},args:{}", event.getRefreshType().toString(), event.getSource());
        if (event.getRefreshType() == RefreshMsgEvent.RefreshType.Constant) {
            this.init();
        }
    }

}

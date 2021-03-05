package com.me.mesite.module.tms.service;

import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.me.mesite.common.utils.MapUtils;
import com.me.mesite.common.utils.Tools;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsKindType;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsKindTypeRepository;
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

    private Map<String, Map<Integer, Object>> cache = Maps.newHashMap();

    @Resource
    private TmsKindTypeRepository tmsKindTypeRepository;

    public TmsKindType getKindType(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (Tools.isEmpty(cache)) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            init();
        }
        Map<Integer, Object> tmsKindTypeCacheMap = cache.get(tmsKindTypeCacheName);
        return (TmsKindType) tmsKindTypeCacheMap.get(kinId);
    }

    @PostConstruct
    void init() {
        cache.clear();
        List<TmsKindType> tmsKindTypes = tmsKindTypeRepository.findAll();
        Map tmsKindTypeCacheMap = tmsKindTypes.stream().collect(Collectors.toMap(TmsKindType::getId, x1 -> x1));
        cache.put(tmsKindTypeCacheName, tmsKindTypeCacheMap);
        log.info("system db ContactCache init...write  TmsKindType", tmsKindTypeCacheMap);
    }



    @EventListener
    public void handleOrderEvent(EventBus event) {
        System.out.println("我监听到了handleOrderEvent发布的message为:" + event.getMsg());
    }

}

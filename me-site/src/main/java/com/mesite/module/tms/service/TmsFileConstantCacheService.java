package com.mesite.module.tms.service;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import com.mesite.common.utils.Tools;
import com.mesite.common.validator.Assert;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeKind;
import com.mesite.module.tms.event.RefreshMsgEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsFileConstantCacheService {

    //获取项目下的学院名称
    private final String tmsKindTypeCacheName = "tmsKindTypeCache";
    private final String tmsSubjectTypeCacheName = "tmsSubjectTypeCache";

    private Map<String, Map<Integer, StemTree>> cache = Maps.newHashMap();

    @Resource
    private TmsTypeKindService tmsTypeKindRepository;
    @Resource
    private TmsTypeCourseService tmsTypeCourseRepository;
    @Resource
    private TmsTypeSubjectService tmsTypeSubjectRepository;

    public Map<String, Map<Integer, StemTree>> getStemTreeCache() {
        if (cache.isEmpty()) {
            this.init();
        }
        return cache;
    }


    public StemTree getKD(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (Tools.isEmpty(cache)) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            this.init();
        }
        Map<Integer, StemTree> tmsKindTypeCacheMap = cache.get(tmsKindTypeCacheName);
        return tmsKindTypeCacheMap.get(kinId);
    }

    @PostConstruct
    private void init() {
        cache.clear();
        //缓存项目分类信息
        Map<Integer, StemTree> tmsKindTypeCacheMap = new HashMap<>();

        List<TmsTypeKind> tmsKindTypes = tmsTypeKindRepository.list();
        List<TmsTypeKind> tmsRootTypeKinds = tmsKindTypes.stream()
                .filter(item -> item.getPid() == 0)
                .collect(Collectors.toList());

        tmsRootTypeKinds.forEach(i -> {
            StemTree stemTree = new StemTree(i);
            List<StemTree> typeItemKindList = tmsKindTypes.stream()
                    .filter(i1 -> i1.getPid().equals(stemTree.getId()))
                    .map(StemTree::new)
                    .collect(Collectors.toList());
            stemTree.setItemRecords(typeItemKindList);

            tmsKindTypeCacheMap.put(i.getId(), stemTree);
        });
        cache.put(tmsKindTypeCacheName, tmsKindTypeCacheMap);
        log.info("system db ContactCache write TmsKindType:{} success", tmsKindTypeCacheMap);
        //缓存项目信息
    }


    @EventListener(classes = RefreshMsgEvent.class)
    public void handleRefreshMsgEvent(RefreshMsgEvent event) {
        log.info("RefreshMsgEvent execute refresh ,type:{},args:{}", event.getRefreshType().toString(), event.getSource());
        if (event.getRefreshType() == RefreshMsgEvent.RefreshType.Constant) {
            this.init();
        }
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    class StemTree extends TmsTypeKind {

        private List<StemTree> itemRecords;

        StemTree(TmsTypeKind tmsTypeKind) {
            BeanUtils.copyProperties(tmsTypeKind, this);
        }
    }


}

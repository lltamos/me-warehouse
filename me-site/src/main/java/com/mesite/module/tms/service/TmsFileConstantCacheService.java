package com.mesite.module.tms.service;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.mesite.common.utils.Tools;
import com.mesite.common.validator.Assert;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeCourse;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeKind;
import com.mesite.module.tms.event.RefreshMsgEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsFileConstantCacheService {

    private Map<Integer, Tree<Integer>> tmsKindTypeCache = Maps.newHashMap();
    private Map<String, Map<Integer, Tree<Integer>>> tmsSubjectTypeCache = Maps.newHashMap();
    private Map<Integer, Collection<TmsTypeCourse>> tmsCourseTypeCache = Maps.newHashMap();

    @Resource
    private TmsTypeKindService tmsTypeKindRepository;
    @Resource
    private TmsTypeCourseService tmsTypeCourseRepository;
    @Resource
    private TmsTypeSubjectService tmsTypeSubjectRepository;

    public Collection<Tree<Integer>> getKindTypeTreeList() {
        this.checkInit();
        return tmsKindTypeCache.values();
    }

    public Collection<TmsTypeCourse> getCourseTypeTreeList(Integer tmsKindId) {
        this.checkInit();
        return tmsCourseTypeCache.get(tmsKindId);
    }

    public Map<Integer, Tree<Integer>> getKindTypeTreeMap() {
        this.checkInit();
        return tmsKindTypeCache;
    }

    public Tree<Integer> getKD(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (Tools.isEmpty(tmsKindTypeCache)) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            this.init();
        }
        return tmsKindTypeCache.get(kinId);
    }

    private void checkInit() {
        if (tmsKindTypeCache.isEmpty() || tmsCourseTypeCache.isEmpty()) {
            this.init();
        }
    }

    @PostConstruct
    private void init() {
        tmsKindTypeCache.clear();
        tmsCourseTypeCache.clear();
        //缓存项目分类信息
        List<TmsTypeKind> tmsKindTypes = tmsTypeKindRepository.list();
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("order");
        treeNodeConfig.setIdKey("tid");
        // 最大递归深度
        treeNodeConfig.setDeep(3);
        //转换器
        List<Tree<Integer>> treeNodes = TreeUtil.build(tmsKindTypes, 0, treeNodeConfig,
                (node, tree) -> {
                    tree.setId(node.getId());
                    tree.setParentId(node.getPid());
                    tree.setWeight(node.getRanked());
                    tree.setName(node.getName());
                });
        //转换成MAP
        Map<Integer, Tree<Integer>> tmsKindTypeCacheMap = treeNodes.stream().collect(Collectors.toMap(Tree::getId, X1 -> X1));
        tmsKindTypeCache.putAll(tmsKindTypeCacheMap);


        //缓存课程分类信息
        List<TmsTypeCourse> tmsTypeCourses = tmsTypeCourseRepository.list();

        HashMultimap<Integer, TmsTypeCourse> tmsCourseTypeCacheMap = HashMultimap.create();
        tmsTypeCourses.forEach(item -> {
            Integer tmsKindTypeId = item.getTmsKindTypeId();
            tmsCourseTypeCacheMap.put(tmsKindTypeId, item);
        });
        tmsCourseTypeCache.putAll(tmsCourseTypeCacheMap.asMap());

        log.info("system db ContactCache write TmsKindType:{} success，TmsCourseType:{}", tmsKindTypeCache, tmsCourseTypeCache);
    }

    //todo 需要在项目或者课程更新操作之后发送事件
    @EventListener(classes = RefreshMsgEvent.class)
    public void handleRefreshMsgEvent(RefreshMsgEvent event) {
        log.info("RefreshMsgEvent execute refresh ,type:{},args:{}", event.getRefreshType().toString(), event.getSource());
        if (event.getRefreshType() == RefreshMsgEvent.RefreshType.Constant) {
            this.init();
        }

    }
}

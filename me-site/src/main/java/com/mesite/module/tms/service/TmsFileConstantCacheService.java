package com.mesite.module.tms.service;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.mesite.common.utils.Tools;
import com.mesite.common.validator.Assert;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeChapter;
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

    private Map<Integer, Tree<Integer>> tmsKindTypeCache = Maps.newTreeMap();
    private Map<Integer, Collection<TmsTypeCourse>> tmsCourseTypeCache = Maps.newTreeMap();
    private Map<Integer, Collection<TmsTypeChapter>> tmsChapterTypeCache = Maps.newTreeMap();

    @Resource
    private TmsTypeKindService tmsTypeKindRepository;
    @Resource
    private TmsTypeCourseService tmsTypeCourseRepository;
    @Resource
    private TmsTypeChapterService tmsTypeChapterService;


    public Collection<Tree<Integer>> getKindTypeList() {
        this.checkInit();
        return tmsKindTypeCache.values();
    }

    public Collection<TmsTypeCourse> getCourseTypeList(Integer tmsKindId) {
        this.checkInit();
        return tmsCourseTypeCache.get(tmsKindId);
    }

    public Collection<TmsTypeChapter> getChapterTypeList(Integer tmsCourseId) {
        this.checkInit();
        return tmsChapterTypeCache.get(tmsCourseId);
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
        tmsChapterTypeCache.clear();
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

        ArrayListMultimap<Integer, TmsTypeCourse> tmsCourseTypeMultiMap = ArrayListMultimap.create();
        tmsTypeCourses.forEach(item -> {
            Integer tmsKindTypeId = item.getTmsKindTypeId();
            tmsCourseTypeMultiMap.put(tmsKindTypeId, item);
        });
        tmsCourseTypeCache.putAll(tmsCourseTypeMultiMap.asMap());

        //缓存课程下的章节
        List<TmsTypeChapter> tmsTypeChapters = tmsTypeChapterService.list();
        ArrayListMultimap<Integer, TmsTypeChapter> typeChapterMultiMap = ArrayListMultimap.create();
        tmsTypeChapters.forEach(item -> {
            Integer tmsCourseTypeId = item.getTmsCourseTypeId();
            typeChapterMultiMap.put(tmsCourseTypeId, item);
        });
        tmsChapterTypeCache.putAll(typeChapterMultiMap.asMap());
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

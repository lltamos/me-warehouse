package com.mesite.module.tms.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import com.mesite.common.utils.Tools;
import com.mesite.common.validator.Assert;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeKind;
import com.mesite.module.tms.event.RefreshMsgEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.runtime.Inner;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
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

    private Map<String, Map<Integer, Tree<Integer>>> cache = Maps.newHashMap();

    @Resource
    private TmsTypeKindService tmsTypeKindRepository;
    @Resource
    private TmsTypeCourseService tmsTypeCourseRepository;
    @Resource
    private TmsTypeSubjectService tmsTypeSubjectRepository;

    public Map<Integer, Tree<Integer>> getKindTypeTreeCache() {
        if (cache.isEmpty()) {
            this.init();
        }
        return cache.get(tmsKindTypeCacheName);
    }


    public Tree<Integer> getKD(Integer kinId) {

        Assert.isNull(kinId, "kindId is Null");

        if (Tools.isEmpty(cache)) {
            log.warn("********************************tmsKindTypeCache is null application execute plan init ");
            this.init();
        }
        Map<Integer, Tree<Integer>> tmsKindTypeCacheMap = cache.get(tmsKindTypeCacheName);
        return tmsKindTypeCacheMap.get(kinId);
    }

    @PostConstruct
    private void init() {
        cache.clear();
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
        cache.put(tmsKindTypeCacheName, tmsKindTypeCacheMap);
        log.info("system db ContactCache write TmsKindType:{} success", tmsKindTypeCacheMap);
    }


    @EventListener(classes = RefreshMsgEvent.class)
    public void handleRefreshMsgEvent(RefreshMsgEvent event) {
        log.info("RefreshMsgEvent execute refresh ,type:{},args:{}", event.getRefreshType().toString(), event.getSource());
        if (event.getRefreshType() == RefreshMsgEvent.RefreshType.Constant) {
            this.init();
        }

    }
}

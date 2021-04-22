package com.mesite.module.tms.service;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeCourse;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeKind;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeSubject;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TmsFileConstantCacheServiceTest {
    @Resource
    TmsFileConstantCacheService tmsFileConstantCacheService;
    @Resource
    private TmsTypeKindService tmsTypeKindRepository;
    @Resource
    private TmsTypeSubjectService tmsTypeSubjectRepository;
    @Resource
    private TmsTypeCourseService tmsTypeCourseRepository;

    @Test
    void getTypeKind() {
        List<TmsTypeKind> list = tmsTypeKindRepository.list();
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("order");
        treeNodeConfig.setIdKey("rid");
        // 最大递归深度
        treeNodeConfig.setDeep(3);
        //转换器
        List<Tree<String>> treeNodes = TreeUtil.build(list, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId().toString());
                    tree.setParentId(treeNode.getPid().toString());
                    tree.setWeight(treeNode.getRanked());
                    tree.setName(treeNode.getName());
                });

        System.out.println(JSONUtil.toJsonStr(treeNodes));
    }



}
package com.mesite.module.tms.service.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.mesite.domain.common.BasePage;
import com.mesite.module.tms.entity.TmsTestRepsVo;
import com.mesite.module.tms.service.TmsTestRepsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class TmsTestRepsServiceImplTest {
    @Resource
    TmsTestRepsService tmsTestRepsService;

    @Test
    void findTestPagerLists() {
        BasePage<TmsTestRepsVo> testRepsLists = tmsTestRepsService.findTestRepsLists(1, 50, null);

        System.out.println(JSONUtil.parse(testRepsLists));
    }
}
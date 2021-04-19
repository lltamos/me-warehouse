package com.mesite.module.tms.service.impl;

import cn.hutool.json.JSONUtil;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.service.TmsTestRepsService;
import com.mesite.module.tms.service.TmsTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TmsTestServiceImplTest {
    @Resource
    TmsTestService tmsTestService;

    @Test
    void findTestLists() {
        TmsSearchBo tmsSearchBo = new TmsSearchBo();
        tmsSearchBo.setTestRepsId(1);
        System.out.println(JSONUtil.parse(tmsTestService.findTestLists(tmsSearchBo)));
    }
}
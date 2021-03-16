package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.MeData;
import com.me.mesite.domain.vo.TmsQuestionVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class TmsQuestionServiceTest {
    @Resource
    private TmsQuestionService tmsQuestionService;

    @Test
    void findQuestionLists() {
        MeData<List<TmsQuestionVo>> questionLists = tmsQuestionService.findQuestionLists(1, 1, "经济全球化从内容上大体可以分为");
        log.info("111",questionLists);


    }
}
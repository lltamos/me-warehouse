package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsKindType;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import com.me.mesite.module.tms.service.TmsFileConstantCacheService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class TmsQuestionRepsRepositoryTest {

    @Resource
    TmsQuestionRepsRepository tmsQuestionRepsRepository;
    @Resource
    TmsFileConstantCacheService tmsFileConstantService;

    @Test
    void test() {
        log.debug("xxxxxxxxxxxxxxxxxx");
    }

    @Test
    void findTmsQuestionRepsByNameStartsWith() {
        List<TmsQuestionReps> all = tmsQuestionRepsRepository.findAll();

        all.forEach(item -> {

            Integer id = item.getTmsKindTypeId();
            TmsKindType kindType = tmsFileConstantService.getKindType(id);
            item.setTmsKindTypeStr(kindType.getName());
            tmsQuestionRepsRepository.save(item);
        });
    }
}
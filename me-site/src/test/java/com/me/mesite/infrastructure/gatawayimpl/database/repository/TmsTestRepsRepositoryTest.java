package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestReps;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeKind;
import com.me.mesite.module.tms.service.TmsFileConstantCacheService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class TmsTestRepsRepositoryTest {

    @Resource
    TmsTestRepsRepository tmsTestRepsRepository;
    @Resource
    TmsFileConstantCacheService tmsFileConstantService;

    @Test
    void test() {
        log.debug("xxxxxxxxxxxxxxxxxx");
    }

    @Test
    void findTmsTestRepsByNameStartsWith() {
        List<TmsTestReps> all = tmsTestRepsRepository.findAll();

        all.forEach(item -> {

            Integer id = item.getTmsKindTypeId();
            TmsTypeKind kindType = tmsFileConstantService.getTypeKind(id);
            item.setTmsKindTypeStr(kindType.getName());
            tmsTestRepsRepository.save(item);
        });
    }
}
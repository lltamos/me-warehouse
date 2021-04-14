package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.module.tms.service.TmsTestRepsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class TmsTestRepositoryTest {
    @Resource
    TmsTestRepository tmsTestRepository;
    @Resource
    TmsTestRepsService tmsTestRepsService;
    @Test
    void test() {
    }

}
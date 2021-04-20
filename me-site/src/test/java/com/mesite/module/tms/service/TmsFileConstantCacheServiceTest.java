package com.mesite.module.tms.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TmsFileConstantCacheServiceTest {
    @Resource
    TmsFileConstantCacheService tmsFileConstantCacheService;

    @Test
    void getTypeKind() {

        System.out.println( tmsFileConstantCacheService.getStemTreeCache());
    }
}
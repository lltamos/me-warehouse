package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TmsChapterTypeRepositoryTest {
    @Resource
    TmsChapterTypeRepository tmsChapterTypeRepository;

    @Test
    void test(){
        List<TmsChapterType> all = tmsChapterTypeRepository.findAll();
        System.out.println(all.size());

    }

}
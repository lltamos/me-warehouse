package com.me.mesite.module.tms.service;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class TmsTestPagerServiceTest {
    @Resource
    private TmsTestPagerService tmsTestPagerService;
    @Resource
    private TmsTestPagerRepository tmsTestPagerRepository;

    @Test
    void findTestPagerLists() {

    }


    @Test
    void updateCtime() {
        List<TmsTestPager> tmsTestPagers = tmsTestPagerRepository.findAll();
        List<TmsTestPager> tmsTestPagersSave = new ArrayList<>();
        for (int i = 0; i < tmsTestPagers.size(); i++) {
            TmsTestPager tmsTestPager = tmsTestPagers.get(i);
            if (tmsTestPager.getCtime() != null) {
                continue;
            }
            tmsTestPager.setCtime(tmsTestPager.getUtime());
            tmsTestPagersSave.add(tmsTestPager);
        }
        System.out.println("执行更新：" + tmsTestPagersSave.size());
        tmsTestPagerRepository.saveAll(tmsTestPagersSave);
        System.out.println("更新完毕");
    }
}
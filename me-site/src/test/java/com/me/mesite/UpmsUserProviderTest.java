package com.me.mesite;

import cn.hutool.json.JSONUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.google.common.collect.Lists;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.UpmsCUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UpmsUserProviderTest {
    @Resource
    UpmsCUserRepository upmsCUserRepository;

    @Test
    void save() {
        List<UpmsCUser> uses = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            uses.add(DataUtil.build(UpmsCUser.class));
        }
        uses.stream().map(item -> {
            item.setId(null);
            return item;
        });
        List<UpmsCUser> upmsUsers = upmsCUserRepository.saveAll(uses);
    }

    @Test
    void findAll() {
        List<UpmsCUser> upmsUsers = upmsCUserRepository.findAll();
        System.out.println(JSONUtil.toJsonStr(upmsUsers));
    }
}

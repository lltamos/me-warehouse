package com.me.mesite;

import cn.hutool.json.JSONUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.google.common.collect.Lists;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.MeUser;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.MeUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MeUserProviderTest {
    @Resource
    MeUserRepository meUserRepository;

    @Test
    void save() {
        List<MeUser> uses = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            uses.add(DataUtil.build(MeUser.class));
        }
        uses.stream().map(item -> {
            item.setId(null);
            return item;
        });
        List<MeUser> meUsers = meUserRepository.saveAll(uses);
    }

    @Test
    void findAll() {
        List<MeUser> meUsers = meUserRepository.findAll();
        System.out.println(JSONUtil.toJsonStr(meUsers));
    }
}

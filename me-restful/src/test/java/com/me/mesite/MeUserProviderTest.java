package com.me.mesite;

import cn.hutool.json.JSONUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.me.mesite.database.entity.MeUser;
import com.me.mesite.database.repository.MeUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MeUserProviderTest {
    @Resource
    MeUserRepository meUserRepository;

    @Test
    void contextLoads() {
        List<MeUser> uses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            uses.add(DataUtil.build(MeUser.class));
        }
        Lists

        uses.stream().map(item -> {
            item.setId(null);
            return item;
        });
        List<MeUser> meUsers = meUserRepository.saveAll(uses);
    }
}

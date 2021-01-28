package com.me.mesite;

import cn.hutool.json.JSONUtil;
import com.me.mesite.database.entity.UpmsSysUser;
import com.me.mesite.database.repository.UpmsSysUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MeSiteApplicationTests {
    @Resource
    UpmsSysUserRepository upmsSysuserRepository;

    @Test
    void contextLoads() {
        List<UpmsSysUser> upmsSysUsers = upmsSysuserRepository.findAll();
        System.out.println(JSONUtil.toJsonStr(upmsSysUsers));
    }
}

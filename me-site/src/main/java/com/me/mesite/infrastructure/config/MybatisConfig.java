package com.me.mesite.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.me.mesite.infrastructure.gatawayimpl.database.mapper")
public class MybatisConfig {
}

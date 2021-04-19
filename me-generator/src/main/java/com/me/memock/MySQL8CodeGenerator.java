package com.me.memock;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.me.memock.util.CommonUtils;

/**
 * MySQL 数据库代码生成类
 * @author Erwin Feng
 * @since 2019-04-17 10:33
 */
public class MySQL8CodeGenerator {

    public static void main(String[] args) {

        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://182.92.71.18:3306/me_warehouse?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "me_warehouse";
        String password = "P3RXRJapNh5M3zdD";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 基础包名
        String packageName = "com.mesite.infrastructure.gatewayimpl.database";


       CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }

}

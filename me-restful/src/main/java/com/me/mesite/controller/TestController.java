package com.me.mesite.controller;

import com.me.mesite.database.UpmsUser;
import com.me.mesite.database.UpmsUserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    UpmsUserDao upmsUserDao;


    @GetMapping("/ok")
    public String ok() {
        UpmsUser upmsUser = upmsUserDao.selectByPrimaryKey(1);
        return upmsUser.toString();
    }
}

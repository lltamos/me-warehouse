package com.me.mesite.module.Idds.controller.upms;

import com.me.mesite.common.utils.R;
import com.me.mesite.database.entity.MeUser;
import com.me.mesite.module.Idds.service.MeUserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Resource
    private MeUserService meUserService;

    @GetMapping("list")
    public R findAll(Integer from, Integer limit) {
        return R.ok(meUserService.findAll(from, limit));
    }

    @GetMapping("get/{id}")
    public R findAll(@PathVariable("id") Long id) {
        return R.ok(meUserService.findById(id));
    }

    @PostMapping("Edit/{id}")
    public R findAll(@PathVariable("id") Long id, MeUser meUser) {
        return R.ok(meUserService.save(id, meUser));
    }

}

package com.me.mesite.module.Idds.web.upms;

import com.me.mesite.common.utils.R;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.MeUser;
import com.me.mesite.module.Idds.service.MeUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Resource
    private MeUserService meUserService;

    @GetMapping("list")
    public R findAll(Integer page, Integer limit, String key) {
        return R.ok(meUserService.findMeLists(page, limit,key));
    }

    @GetMapping("get")
    public R findAll(Long id) {
        return R.ok(meUserService.findById(id));
    }

    @PostMapping("edit")
    public R findAll(@RequestBody MeUser meUser) {
        return R.ok(meUserService.save(meUser));
    }

    @GetMapping("delete")
    public R delete(Long id) {
        meUserService.delete(id);
        return R.okStr();
    }

}

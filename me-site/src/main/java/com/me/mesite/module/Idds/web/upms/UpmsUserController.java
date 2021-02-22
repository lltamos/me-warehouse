package com.me.mesite.module.Idds.web.upms;

import com.me.mesite.common.utils.R;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import com.me.mesite.module.Idds.service.MeUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Resource
    private MeUserService meUserService;

    @GetMapping("list")
    public R list(Integer page, Integer limit, String key) {
        return R.ok(meUserService.findMeLists(page, limit,key));
    }

    @GetMapping("get")
    public R get(Long id) {
        return R.ok(meUserService.findById(id));
    }

    @PostMapping("edit")
    public R edit(@RequestBody UpmsCUser upmsUser) {
        return R.ok(meUserService.save(upmsUser));
    }

    @GetMapping("delete")
    public R delete(Long id) {
        meUserService.delete(id);
        return R.okStr();
    }

}

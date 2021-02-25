package com.me.mesite.module.Idds.web.upms;

import com.me.mesite.common.utils.R;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import com.me.mesite.module.Idds.service.UpmsCUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Resource
    private UpmsCUserService upmsCUserService;

    @GetMapping("list")
    public R list(Integer page, Integer limit, String key) {
        return R.ok(upmsCUserService.findMeLists(page, limit,key));
    }

    @GetMapping("get")
    public R get(Integer id) {
        return R.ok(upmsCUserService.findById(id));
    }

    @PostMapping("edit")
    public R edit(@RequestBody UpmsCUser upmsUser) {
        return R.ok(upmsCUserService.save(upmsUser));
    }

    @GetMapping("delete")
    public R delete(Integer id) {
        upmsCUserService.delete(id);
        return R.okStr();
    }

}

package com.me.mesite.module.Idds.web;

import com.me.mesite.domain.common.Result;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsTrainee;
import com.me.mesite.module.Idds.service.UpmsTraineeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upms/user")
public class UpmsUserController {

    @Resource
    private UpmsTraineeService upmsTraineeService;

    @GetMapping("list")
    public Result list(Integer page, Integer limit, String key) {
        return Result.ok(upmsTraineeService.findMeLists(page, limit,key));
    }

    @GetMapping("get")
    public Result get(Integer id) {
        return Result.ok(upmsTraineeService.findById(id));
    }

    @PostMapping("edit")
    public Result edit(@RequestBody UpmsTrainee upmsUser) {
        return Result.ok(upmsTraineeService.save(upmsUser));
    }

    @GetMapping("delete")
    public Result delete(Integer id) {
        upmsTraineeService.delete(id);
        return Result.ok();
    }

}

package com.mesite.module.tms.web;

import com.mesite.domain.common.Result;
import com.mesite.module.tms.service.TmsFileConstantCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/constant")
public class TmsFileConstantCacheController {
    @Resource
    private TmsFileConstantCacheService tmsFileConstantCacheService;

    @GetMapping("listKindTypeTree")
    public Result listKindTypeTree() {
        return Result.ok(tmsFileConstantCacheService.getKindTypeTreeList());
    }

    @GetMapping("listCourseTypes")
    public Result listCourseTypes(@RequestParam Integer tmsCourseId) {
        return Result.ok(tmsFileConstantCacheService.getCourseTypeTreeList(tmsCourseId));
    }
}

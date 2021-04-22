package com.mesite.module.tms.web;

import com.mesite.domain.common.Result;
import com.mesite.module.tms.service.TmsFileConstantCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/constant")
public class TmsFileConstantCacheController {
    @Resource
    private TmsFileConstantCacheService tmsFileConstantCacheService;

    @GetMapping("list")
    public Result list() {
        return Result.ok(tmsFileConstantCacheService.getStemTreeCache());
    }
}

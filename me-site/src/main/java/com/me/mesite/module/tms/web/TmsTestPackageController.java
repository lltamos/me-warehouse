package com.me.mesite.module.tms.web;

import com.me.mesite.domain.common.Result;
import com.me.mesite.domain.vo.TmsTestPackageVo;
import com.me.mesite.module.tms.entity.TmsSearchBo;
import com.me.mesite.module.tms.service.TmsTestPackageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 试卷
 */
@RestController
@RequestMapping("/tms/package")
public class TmsTestPackageController {

    @Resource
    private TmsTestPackageService tmsTestPackageService;

    @GetMapping("list")
    public Result list(TmsSearchBo tmsSearchBo) {
        return Result.ok(tmsTestPackageService.findTestPackageLists(tmsSearchBo));
    }

    @PostMapping("update")
    public Result update(@RequestBody TmsTestPackageVo tmsTestPackageVo) {
        return Result.ok(tmsTestPackageService.createAndUpdate(tmsTestPackageVo));
    }
}

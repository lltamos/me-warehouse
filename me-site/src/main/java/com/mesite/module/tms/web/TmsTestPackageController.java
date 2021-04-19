package com.mesite.module.tms.web;

import com.mesite.module.tms.service.TmsTestPackageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 试卷
 */
@RestController
@RequestMapping("/tms/package")
public class TmsTestPackageController {

    @Resource
    private TmsTestPackageService tmsTestPackageService;

//    @GetMapping("list")
//    public Result list(TmsSearchBo tmsSearchBo) {
//        return Result.ok(tmsTestPackageService.findTestPackageLists(tmsSearchBo));
//    }
//
//    @PostMapping("update")
//    public Result update(@RequestBody TmsTestPackageVo tmsTestPackageVo) {
//        return Result.ok(tmsTestPackageService.createAndUpdate(tmsTestPackageVo));
//    }
}

package com.mesite.module.tms.web;

import com.mesite.domain.common.Result;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestVo;
import com.mesite.module.tms.service.TmsTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 试题
 */
@RestController
@RequestMapping("/tms/test")
public class TmsTestController {

    @Resource
    private TmsTestService tmsTestService;

    @GetMapping("list")
    public Result list(TmsSearchBo tmsSearchBo) {
        return Result.ok(tmsTestService.findTestLists(tmsSearchBo));
    }

    @PostMapping("update")
    public Result update(TmsTestVo tmsTestVo) {
        return Result.ok(tmsTestService.createAndUpdate(tmsTestVo));
    }

}

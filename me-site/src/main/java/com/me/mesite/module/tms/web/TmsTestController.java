package com.me.mesite.module.tms.web;

import com.me.mesite.domain.common.Result;
import com.me.mesite.domain.vo.TmsTestVo;
import com.me.mesite.module.tms.entity.TmsSearchBo;
import com.me.mesite.module.tms.service.TmsTestService;
import org.springframework.web.bind.annotation.*;

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

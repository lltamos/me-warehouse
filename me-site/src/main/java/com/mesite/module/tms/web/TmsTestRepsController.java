package com.mesite.module.tms.web;

import com.mesite.common.utils.Constants;
import com.mesite.common.validator.Assert;
import com.mesite.domain.common.Result;
import com.mesite.module.tms.service.TmsTestRepsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 试题库
 */
@RestController
@RequestMapping("/tms/reps")
public class TmsTestRepsController {

    @Resource
    private TmsTestRepsService tmsTestRepsService;

    @GetMapping("list")
    public Result list(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.before(page, Constants.ONE, "page validate  fail");
        Assert.isNull(limit, "limit is empty");
        return Result.ok(tmsTestRepsService.findTestRepsLists(page, limit, key));
    }

}

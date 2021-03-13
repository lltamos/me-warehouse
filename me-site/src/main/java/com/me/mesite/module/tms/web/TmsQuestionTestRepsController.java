package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.Constants;
import com.me.mesite.common.utils.R;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.module.tms.service.TmsQuestionTestRepsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tms/reps")
public class TmsQuestionTestRepsController {

    @Resource
    private TmsQuestionTestRepsService tmsQuestionTestRepsService;

    @GetMapping("list")
    public R list(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.before(page, Constants.ONE, "page validate  fail");
        Assert.isNull(limit, "limit is empty");
        return R.ok(tmsQuestionTestRepsService.findQuestionRepsLists(page, limit, key));
    }

}

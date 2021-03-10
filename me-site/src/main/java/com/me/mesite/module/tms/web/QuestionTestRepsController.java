package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.Constants;
import com.me.mesite.common.utils.R;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.module.tms.service.QuestionTestRepsService;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tms/reps")
public class QuestionTestRepsController {

    @Resource
    private QuestionTestRepsService questionTestRepsService;

    @GetMapping("list")
    public R list(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.before(page, Constants.ONE, "page validate  fail");
        Assert.isNull(limit, "limit is empty");
        return R.ok(questionTestRepsService.findQuestionRepsLists(page, limit, key));
    }

}

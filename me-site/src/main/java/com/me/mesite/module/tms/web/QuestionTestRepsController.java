package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.R;
import com.me.mesite.module.tms.service.QuestionTestRepsService;
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
        return R.ok(questionTestRepsService.findQuestionRepsLists(page, limit,key));
    }

}

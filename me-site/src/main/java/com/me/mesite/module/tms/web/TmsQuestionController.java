package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.R;
import com.me.mesite.module.tms.service.TmsQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tms/question")
public class TmsQuestionController {

    @Resource
    private TmsQuestionService tmsQuestionService;

    @GetMapping("list")
    public R list(Integer questionRepsId, Integer txid, String key) {
        return R.ok(tmsQuestionService.findQuestionLists(questionRepsId, txid, key));
    }

    @GetMapping("delete")
    public R delete(Integer id) {
        return R.ok(tmsQuestionService.delete(id));
    }
}

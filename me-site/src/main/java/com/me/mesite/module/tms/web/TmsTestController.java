package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.R;
import com.me.mesite.domain.vo.TmsTestVo;
import com.me.mesite.module.tms.service.TmsTestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tms/test")
public class TmsTestController {

    @Resource
    private TmsTestService tmsTestService;

    @GetMapping("list")
    public R list(Integer testRepsId, Integer txid, String key) {
        return R.ok(tmsTestService.findTestLists(testRepsId, txid, key));
    }

    @PostMapping("update")
    public R update(@RequestBody TmsTestVo tmsTestVo) {
        return R.ok(tmsTestService.createAndUpdate(tmsTestVo));
    }

}

package com.me.mesite.module.tms.web;

import com.me.mesite.domain.common.Result;
import com.me.mesite.domain.vo.TmsTestPagerVo;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPagerRepository;
import com.me.mesite.module.tms.entity.TmsSearchBo;
import com.me.mesite.module.tms.service.TmsTestPagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 试卷
 */
@RestController
@RequestMapping("/tms/paper")
public class TmsTestPagerController {

    @Resource
    private TmsTestPagerService tmsTestPagerService;
    @Resource
    private TmsTestPagerRepository tmsTestPagerRepository;

    @GetMapping("list")
    public Result list(TmsSearchBo tmsSearchBo) {
        return Result.ok(tmsTestPagerService.findTestPagerLists(tmsSearchBo));
    }

    @PostMapping("update")
    public Result update(@RequestBody TmsTestPagerVo tmsTestPagerVo) {
        return Result.ok(tmsTestPagerService.createAndUpdate(tmsTestPagerVo));
    }

    @GetMapping("list")
    public Result paper(Integer id) {
        return Result.ok(null);
    }


}

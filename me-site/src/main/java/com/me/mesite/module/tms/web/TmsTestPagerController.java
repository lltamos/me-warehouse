package com.me.mesite.module.tms.web;

import com.me.mesite.common.utils.R;
import com.me.mesite.domain.vo.TmsTestPagerVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPagerRepository;
import com.me.mesite.module.tms.service.TmsTestPagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tms/paper")
public class TmsTestPagerController {

    @Resource
    private TmsTestPagerService tmsTestPagerService;
    @Resource
    private TmsTestPagerRepository tmsTestPagerRepository;

    @GetMapping("list")
    public R list(Integer tmsKinId, Integer courseId, String key) {
        return R.ok(tmsTestPagerService.findTestPagerLists(tmsKinId, courseId, key));
    }

    @PostMapping("update")
    public R update(@RequestBody TmsTestPagerVo tmsTestPagerVo) {
        return R.ok(tmsTestPagerService.createAndUpdate(tmsTestPagerVo));
    }
}

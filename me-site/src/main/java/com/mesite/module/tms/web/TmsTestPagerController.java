//package com.mesite.module.tms.web;
//
//import com.mesite.domain.common.Result;
//import com.mesite.module.tms.entity.TmsTestPagerVo;
//import com.mesite.module.tms.entity.TmsSearchBo;
//import com.mesite.module.tms.service1.TmsTestPagerService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * 试卷
// */
//@RestController
//@RequestMapping("/tms/paper")
//public class TmsTestPagerController {
//
//    @Resource
//    private TmsTestPagerService tmsTestPagerService;
//    @Resource
//    private TmsTestPagerRepository tmsTestPagerRepository;
//
//    @GetMapping("list")
//    public Result list(TmsSearchBo tmsSearchBo) {
//        return Result.ok(tmsTestPagerService.findTestPagerLists(tmsSearchBo));
//    }
//
//    @PostMapping("update")
//    public Result update(@RequestBody TmsTestPagerVo tmsTestPagerVo) {
//        return Result.ok(tmsTestPagerService.createAndUpdate(tmsTestPagerVo));
//    }
//
//    @GetMapping("view")
//    public Result paper(Integer id) {
//        return Result.ok(tmsTestPagerService.paper(id));
//    }
//
//
//}

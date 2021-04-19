//package com.mesite.module.tms.service1;
//
//import com.mesite.common.validator.Assert;
//import com.mesite.module.tms.entity.TmsTestPaperShipVo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * 题库相关操作
// */
//@Service
//@Slf4j
//public class TmsBusinessMergeService {
//
//    private String TABLE_NAME = "tms_test_paper_ship";
//
//
//
//    /**
//     * 选题
//     */
//    @Transactional
//    public void choiceAndUpdateTestForPaper(TmsTestPaperShipVo testPaperShipVo) {
//
//        Assert.isNull(testPaperShipVo);
//        Assert.isNull(testPaperShipVo.getPaperShipList());
//        Assert.isNull(testPaperShipVo.getTestPaperId());
//
//    }
//
//
//}

package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.Tools;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.domain.vo.TmsTestPaperShipVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperShip;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 题库相关操作
 */
@Service
@Slf4j
public class TmsBusinessMergeService {

    private String TABLE_NAME = "tms_test_paper_ship";

    @Resource
    TmsTestPackageRepository tmsTestPackageRepository;
    @Resource
    TmsTestPagerRepository tmsTestPagerRepository;
    @Resource
    TmsTestRepsRepository tmsTestRepsRepository;
    @Resource
    TmsTestChildRepository tmsTestChildRepository;
    @Resource
    TmsTestPaperShipRepository tmsTestPaperShipRepository;


    /**
     * 选题
     */
    @Transactional
    public void choiceAndUpdateTestForPaper(TmsTestPaperShipVo testPaperShipVo) {

        Assert.isNull(testPaperShipVo);
        Assert.isNull(testPaperShipVo.getPaperShipList());
        Assert.isNull(testPaperShipVo.getTestPaperId());

        List<TmsTestPaperShip> tmsTestPaperShips = testPaperShipVo.getPaperShipList();
        for (TmsTestPaperShip tps : tmsTestPaperShips) {
            if (Tools.checkPrimaryNumber(tps.getId())) {
                //更新
                TmsTestPaperShip updateTestPaperShip = tmsTestPaperShipRepository.getOne(tps.getId());
                Tools.copyPropertiesIgnoreNull(tps, updateTestPaperShip);
            } else {
                tmsTestPaperShipRepository.save(tps);
            }
        }
        log.info("更新{}执行更新完毕", TABLE_NAME);
    }


}

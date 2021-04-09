package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.*;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.domain.common.BasePage;
import com.me.mesite.domain.vo.TmsTestPagerVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperShip;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsTestPaperMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPagerRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPaperShipRepository;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestRepository;
import com.me.mesite.module.tms.entity.TmsSearchBo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TmsTestPagerService {
    @Resource
    private TmsTestPagerRepository tmsTestPagerRepository;

    @Resource
    private TmsTestRepository tmsTestRepository;

    @Resource
    private TmsTestPaperShipRepository tmsTestPaperShipRepository;

    @Resource
    private TmsTestPaperMapper tmsTestPaperMapper;

    public BasePage<TmsTestPager> findTestPagerLists(TmsSearchBo tmsSearchBo) {
        TmsSearchBo tmsSearchBoPre = Optional.ofNullable(tmsSearchBo).orElse(new TmsSearchBo());
        List<TmsTestPager> tmsTestPagers = tmsTestPaperMapper.selectTmsTestPaper(
                tmsSearchBoPre.getTmsKinId(),
                tmsSearchBoPre.getCourseId(),
                tmsSearchBoPre.getKey(),
                tmsSearchBoPre.getCelFrom(),
                tmsSearchBoPre.getLimit());
        BasePage<TmsTestPager> parse = tmsSearchBoPre.parse();
        if (tmsSearchBoPre.isPageType()) {
            Integer countTmsTestPagers = tmsTestPaperMapper.countTmsTestPaper(tmsSearchBoPre.getTmsKinId(),
                    tmsSearchBoPre.getCourseId(),
                    tmsSearchBoPre.getKey());
            return parse.autoInitPageSelfArgsResponse(tmsTestPagers, countTmsTestPagers);
        }
        return parse.autoInitPageSelfArgsResponse(tmsTestPagers);
    }

    public TmsTestPager createAndUpdate(TmsTestPagerVo tmsTestPagerVo) {

        Assert.isNull(tmsTestPagerVo);
        TmsTestPager tmsTestPager = null;
        if (tmsTestPagerVo.getId() != null) {
            tmsTestPager = tmsTestPagerRepository.getOne(tmsTestPagerVo.getId());
            // todo 更新数据
            Tools.copyPropertiesIgnoreNull(tmsTestPagerVo, tmsTestPager);
        }
        Assert.isNull(tmsTestPager);
        return tmsTestPagerRepository.save(tmsTestPager);

    }

    public void paper(Integer id) {
        TmsTestPager tmsTestPager = tmsTestPagerRepository.getOne(id);
        Assert.isNull(tmsTestPager, "TmsTestPager is null");
        List<TmsTestPaperShip> tmsTestPaperShipList = tmsTestPaperShipRepository.findByTmsTestPaperIdOrderByRank(tmsTestPager.getId());
        for (TmsTestPaperShip ship : tmsTestPaperShipList) {
            String tmsTestContent = ship.getTmsTestContent();
            List<Integer> ids = Arrays.stream(tmsTestContent.split(",")).map(NumberUtils::createInteger).collect(Collectors.toList());
            List<TmsTest> tmsTests = tmsTestRepository.findAllById(ids);
        }
    }
}

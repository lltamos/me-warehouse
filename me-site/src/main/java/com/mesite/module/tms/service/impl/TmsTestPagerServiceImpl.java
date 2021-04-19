package com.mesite.module.tms.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.common.validator.Assert;
import com.mesite.domain.common.BasePage;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPager;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTestPagerMapper;
import com.mesite.module.tms.entity.PaperViewBo;
import com.mesite.module.tms.entity.TmsSearchBo;
import com.mesite.module.tms.entity.TmsTestPagerVo;
import com.mesite.module.tms.service.TmsTestPagerService;
import com.mesite.module.tms.service.TmsTestPaperShipService;
import com.mesite.module.tms.service.TmsTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 试卷 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
@Slf4j
public class TmsTestPagerServiceImpl extends ServiceImpl<ITmsTestPagerMapper, TmsTestPager> implements TmsTestPagerService {

    @Resource
    TmsTestPagerService tmsTestPagerService;
    @Resource
    TmsTestService tmsTestService;
    @Resource
    TmsTestPaperShipService tmsTestPaperShipService;


    public BasePage<TmsTestPager> findTestPagerLists(TmsSearchBo tmsSearchBo) {
        TmsSearchBo tmsSearchBoPre = Optional.ofNullable(tmsSearchBo).orElse(new TmsSearchBo());
        return getBaseMapper().findTmsTestPapers(
                tmsSearchBoPre.getTmsKinId(),
                tmsSearchBoPre.getCourseId(),
                tmsSearchBoPre.getKey(),
                tmsSearchBoPre.parse());
    }


    public boolean createAndUpdate(TmsTestPagerVo tmsTestPagerVo) {
        Assert.isNull(tmsTestPagerVo, "obj cannot is null");
        log.info("试卷信息{}：{}", tmsTestPagerVo.getId() == null ? "新增" : "修改", JSONUtil.toJsonStr(tmsTestPagerVo));
        return this.saveOrUpdate(tmsTestPagerVo);
    }

    public PaperViewBo paper(Integer id) {
        TmsTestPager tmsTestPager = tmsTestPagerService.getById(id);
        Assert.isNull(tmsTestPager, "TmsTestPager is null");
        PaperViewBo paperViewBo = new PaperViewBo();
        //拷贝属性
        paperViewBo.setPagerInfo(tmsTestPager);
        List<TmsTestPaperShip> tmsTestPaperShipList = tmsTestPaperShipService.findTmsPaperIdOrderByRank(tmsTestPager.getId());
        for (TmsTestPaperShip ship : tmsTestPaperShipList) {
            String tmsTestContent = ship.getTmsTestContent();
            List<Integer> ids = Arrays.stream(tmsTestContent.split(",")).map(NumberUtils::createInteger).collect(Collectors.toList());
            List<TmsTest> tmsTests = tmsTestService.listByIds(ids);
            paperViewBo.setPagerTestItem(ship, tmsTests);
        }
        return paperViewBo;
    }

    @Override
    public TmsTestPager getOne(Wrapper<TmsTestPager> queryWrapper) {
        return super.getOne(queryWrapper);
    }
}

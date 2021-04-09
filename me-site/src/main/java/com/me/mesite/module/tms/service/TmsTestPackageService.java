package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.*;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.domain.common.BasePage;
import com.me.mesite.domain.vo.TmsTestPackageVo;
import com.me.mesite.domain.vo.TmsTestVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPackage;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsTestPackageMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPackageRepository;
import com.me.mesite.module.tms.entity.TmsSearchBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TmsTestPackageService {
    @Resource
    private TmsTestPackageMapper tmsTestPackageMapper;

    @Resource
    private TmsTestPackageRepository tmsTestPackageRepository;


    public BasePage<TmsTestPackage> findTestPackageLists(TmsSearchBo tmsSearchBo) {
        TmsSearchBo tmsSearchBoPre = Optional.ofNullable(tmsSearchBo).orElse(new TmsSearchBo());
        List<TmsTestPackage> tmsTestPackages = tmsTestPackageMapper.selectTmsTestPackage(
                tmsSearchBoPre.getTmsKinId(),
                tmsSearchBoPre.getCourseId(),
                tmsSearchBoPre.getKey(),
                tmsSearchBoPre.getCelFrom(),
                tmsSearchBoPre.getLimit());

        BasePage<TmsTestPackage> parse = tmsSearchBoPre.parse();

        if (tmsSearchBoPre.isPageType()) {
            Integer countTmsTestPackages = tmsTestPackageMapper.countTmsTestPackage(
                    tmsSearchBoPre.getTmsKinId(),
                    tmsSearchBoPre.getCourseId(),
                    tmsSearchBoPre.getKey());
            return parse.autoInitPageSelfArgsResponse(tmsTestPackages, countTmsTestPackages);
        }
        return parse.autoInitPageSelfArgsResponse(tmsTestPackages);
    }

    public TmsTestPackage createAndUpdate(TmsTestPackageVo tmsTestPagerVo) {

        Assert.isNull(tmsTestPagerVo);
        TmsTestPackage tmsTestPackage = null;
        if (tmsTestPagerVo.getId() != null) {
            tmsTestPackage = tmsTestPackageRepository.getOne(tmsTestPagerVo.getId());
            // todo 更新数据
            Tools.copyPropertiesIgnoreNull(tmsTestPagerVo, tmsTestPackage);
        }
        Assert.isNull(tmsTestPackage);
        return tmsTestPackageRepository.save(tmsTestPackage);

    }

}

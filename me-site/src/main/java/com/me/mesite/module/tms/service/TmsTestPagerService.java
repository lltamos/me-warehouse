package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.*;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.domain.vo.TmsTestPagerVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsTestPaperMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestPagerRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TmsTestPagerService {
    @Resource
    private TmsTestPagerRepository tmsTestPagerRepository;

    @Resource
    private TmsTestPaperMapper tmsTestPaperMapper;

    public MeData<List> findTestPagerLists(Integer tmsKindId, Integer tmsCourseId, String key) {

        RequestUtils.Param param = RequestUtils.parseRequestBaseParam();
        if (StringUtils.isEmpty(key)) {
            key = null;
        }
        List<TmsTestPager> tmsTestPagers = tmsTestPaperMapper.selectTmsTestPaper(tmsKindId, tmsCourseId, key, param.getCelFrom(), param.getLimit());
        if (param.isPaging()) {
            Integer countTmsTestPagers = tmsTestPaperMapper.countTmsTestPaper(tmsKindId, tmsCourseId, key);
            return PageMeData.autoInitPageSelfArgsResponse(tmsTestPagers, countTmsTestPagers, param.getLimit(), param.getPage());
        }
        return SimpleMeData.initSimpleResponse(tmsTestPagers);
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
}

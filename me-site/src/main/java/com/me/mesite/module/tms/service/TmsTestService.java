package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.*;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.domain.vo.TmsTestVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsTestMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsTestRepository;
import com.me.mesite.module.tms.enums.QuestionEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsTestService {

    @Resource
    private TmsTestRepository tmsTestRepository;
    @Resource
    private TmsTestMapper tmsTestMapper;

    public MeData findTestLists(Integer questionRepsId, Integer txid, String key) {

        RequestUtils.Param param = RequestUtils.parseRequestBaseParam();
        if (StringUtils.isEmpty(key)) {
            key = null;
        }
        List<TmsTestVo> tmsTestVos = tmsTestMapper.selectByTmsTestIdAndTxIdTiganLike(questionRepsId,
                txid,
                key,
                param.getCelFrom(),
                param.getLimit()).stream().map(item -> {
            TmsTestVo vo = new TmsTestVo();
            BeanUtils.copyProperties(item, vo);
            vo.setTxStr(QuestionEnum.getVal(item.getTxId()));
            return vo;
        }).collect(Collectors.toList());


        if (param.isPaging()) {
            Integer countTmsTests = tmsTestMapper.countByTmsTestIdAndTxIdTiganLike(questionRepsId,
                    txid,
                    key);
            return PageMeData.autoInitPageSelfArgsResponse(tmsTestVos, countTmsTests, param.getLimit(), param.getPage());
        }

        return SimpleMeData.initSimpleResponse(tmsTestVos);
    }

    public TmsTest createAndUpdate(TmsTestVo tmsTestVo) {
        Assert.isNull(tmsTestVo);
        TmsTest tmsTest = null;
        if (tmsTestVo.getId() != null) {
            tmsTest = tmsTestRepository.getOne(tmsTestVo.getId());
            // todo 更新数据
            Tools.copyPropertiesIgnoreNull(tmsTestVo, tmsTest);
        }
        Assert.isNull(tmsTest);
        return tmsTestRepository.save(tmsTest);
    }


//    public TmsQuestion delete(Integer id) {
//        TmsQuestion tmsQuestion = tmsQuestionRepository.getOne(id);
//        if (tmsQuestion.getTxId()==5){
//            //级联删除子实体
//        }
//        return tmsQuestion;
//    }


}

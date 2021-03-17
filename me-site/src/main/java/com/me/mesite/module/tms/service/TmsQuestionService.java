package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.PageMeData;
import com.me.mesite.common.utils.RequestUtils;
import com.me.mesite.common.utils.MeData;
import com.me.mesite.common.utils.SimpleMeData;
import com.me.mesite.domain.vo.TmsQuestionVo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestion;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsQuestionMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepository;
import com.me.mesite.module.tms.enums.QuestionEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TmsQuestionService {

    @Resource
    private TmsQuestionRepository tmsQuestionRepository;
    @Resource
    private TmsQuestionMapper tmsQuestionMapper;

    public MeData findQuestionLists(Integer questionRepsId, Integer txid, String key) {

        RequestUtils.Param param = RequestUtils.parseRequestBaseParam();
        if (StringUtils.isEmpty(key)) {
            key = null;
        }
        List<TmsQuestionVo> tmsQuestionVos = tmsQuestionMapper.selectByTmsQuestionIdAndTxIdTiganLike(questionRepsId,
                txid,
                key,
                param.getCelFrom(),
                param.getLimit()).stream().map(item -> {
            TmsQuestionVo vo = new TmsQuestionVo();
            BeanUtils.copyProperties(item, vo);
            vo.setTxStr(QuestionEnum.getVal(item.getTxId()));
            return vo;
        }).collect(Collectors.toList());

        if (param.isPaged()) {
            Integer total;
            if (txid == null) {
                total = tmsQuestionRepository.countByTmsQuestionRepsId(questionRepsId);
            } else {
                total = tmsQuestionRepository.countByTmsQuestionRepsIdAndTxId(questionRepsId, txid);
            }
            return PageMeData.autoInitPageSelfArgsResponse(tmsQuestionVos, total, param.getLimit(), param.getPage());
        }

        return SimpleMeData.initSimpleResponse(tmsQuestionVos);


    }

    public TmsQuestion delete(Integer id) {
        TmsQuestion tmsQuestion = tmsQuestionRepository.getOne(id);
//        if (tmsQuestion.getTxId()==5){
//            //级联删除子实体
//        }
        return tmsQuestion;
    }


    //去掉题冒题概念



    public void ct() {
        List<TmsQuestion> byTimao = tmsQuestionRepository.findByTimao(1);
        for (int i = 0; i < byTimao.size(); i++) {
            TmsQuestion tmsQuestion = byTimao.get(i);
            tmsQuestion.setTxId(5);
            tmsQuestionRepository.save(tmsQuestion);
        }
        log.info("长度：{}",byTimao.size());
    }

}

package com.me.mesite.module.tms.service;

import com.me.mesite.common.utils.PageResponse;
import com.me.mesite.common.utils.RequestUtils;
import com.me.mesite.common.utils.Response;
import com.me.mesite.common.utils.SimpleResponse;
import com.me.mesite.domain.vo.TmsQuestionVo;
import com.me.mesite.infrastructure.gatawayimpl.database.mapper.TmsQuestionMapper;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.TmsQuestionRepository;
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
public class TmsQuestionService {

    @Resource
    private TmsQuestionRepository tmsQuestionRepository;
    @Resource
    private TmsQuestionMapper tmsQuestionMapper;

    public Response findQuestionLists(Integer questionRepsId, Integer txid, String key) {

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
            return PageResponse.autoInitPageSelfArgsResponse(tmsQuestionVos, total, param.getLimit(), param.getPage());
        }

        return SimpleResponse.initSimpleResponse(tmsQuestionVos);


    }
}

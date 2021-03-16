package com.me.mesite.domain.vo;

import com.me.mesite.domain.common.Vo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import org.springframework.beans.BeanUtils;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TmsQuestionVo extends TmsQuestion implements Vo {
    private String txStr;


    public static TmsQuestionVo covert(TmsQuestion tmsQuestion) {
        TmsQuestionVo vo = new TmsQuestionVo();
        BeanUtils.copyProperties(tmsQuestion, vo);
        return vo;
    }
}

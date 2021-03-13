package com.me.mesite.domain.vo;

import com.me.mesite.domain.common.Vo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import lombok.Data;

@Data
public class TmsQuestionRepsVo extends TmsQuestionReps implements Vo {
    private int totalQuestion;
    private int singleChoice;
    private int multipleChoice;
    private int verdict;//判断
    private int interpose;//填空
    private int shortAnswer;
    private int groupQuestion;


}

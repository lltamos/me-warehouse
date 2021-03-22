package com.me.mesite.domain.vo;

import com.me.mesite.domain.common.Vo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestReps;
import lombok.Data;

@Data
public class TmsTestRepsVo extends TmsTestReps implements Vo {
    private int totalQuestion;
    private int singleChoice;
    private int multipleChoice;
    private int verdict;//判断
    private int interpose;//填空
    private int shortAnswer;
    private int groupQuestion;


}

package com.mesite.module.tms.entity;

import com.mesite.domain.common.Vo;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestReps;
import com.mesite.module.tms.enums.QuestionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TmsTestRepsVo extends TmsTestReps implements Vo {
    private int totalQuestion;
    private int singleChoice;
    private int multipleChoice;
    private int verdict;//判断
    private int interpose;//填空
    private int shortAnswer;
    private int groupQuestion;

    public void setTotalQuestion() {
        this.totalQuestion = singleChoice + multipleChoice + verdict + interpose + shortAnswer + groupQuestion;
    }

    public void parseRepsTestData(Integer tx, Integer countNum) {
        QuestionEnum QE = QuestionEnum.parse(tx);
        if (QE != null)
            switch (QE) {
                case SINGLE_CHOICE:
                    this.singleChoice = countNum;
                    break;
                case VERDICT:
                    this.verdict = countNum;
                    break;
                case INTERPOSE:
                    this.interpose = countNum;
                    break;
                case SHORT_ANSWER:
                    this.shortAnswer = countNum;
                    break;
                case GROUP_QUESTION:
                    this.groupQuestion = countNum;
                    break;
                case MULTIPLE_CHOICE:
                    this.multipleChoice = countNum;
                    break;
            }


    }


}

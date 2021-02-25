package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 试题库
 */
@Entity(name = "tms_question_reps")
@Data
public class TmsQuestionReps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * tms_kind_type 主键ID
     */
    private Integer tmsKindTypeId;

    private String tmsKindTypeStr;

    private Integer locked;

    private Date ctime;

    private Date utime;

}

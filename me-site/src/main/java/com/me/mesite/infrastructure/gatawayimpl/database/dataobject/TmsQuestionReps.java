package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tms_question_reps")
@Data
public class TmsQuestionReps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * tms_kind_type 主键ID
     */
    private Integer kindId;

    private String kindStr;

    private Integer locked;

    private Date ctime;

    private Date utime;

}

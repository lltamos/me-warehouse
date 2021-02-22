package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tms_course_type")
@Data
public class TmsCourseType {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 学院
     */
    private Integer kind;
    /**
     * 课程类型：1专业课，2公共课
     */
    private Integer kc_type;
    /**
     * 阶段：1本科，0专科
     */
    private Integer kc_stage;
    /**
     * 课程名字
     */
    private Integer kc_name;
    /**
     * 课程代码
     */
    private Integer code;

    private Integer locked;

    private Date ctime;

    private Date utime;




}

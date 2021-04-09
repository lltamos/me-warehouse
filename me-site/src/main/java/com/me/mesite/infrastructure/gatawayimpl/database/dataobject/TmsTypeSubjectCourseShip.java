package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 专业和课程关联表
 */
@Data
@Entity
@Table(name = "tms_type_subject_course_ship")
public class TmsTypeSubjectCourseShip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业课程
     */
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专业id
     */
    @Column(name = "tms_subject_type_id", nullable = false)
    private Integer tmsSubjectTypeId;

    /**
     * 课程id
     */
    @Column(name = "tms_course_type_id", nullable = false)
    private Integer tmsCourseTypeId;

    /**
     * 1审核 正常  0 审核 未通过
     */
    @Column(name = "locked")
    private Integer locked;

    /**
     * 添加时间
     */
    @Column(name = "ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @Column(name = "utime")
    private Date utime;

}

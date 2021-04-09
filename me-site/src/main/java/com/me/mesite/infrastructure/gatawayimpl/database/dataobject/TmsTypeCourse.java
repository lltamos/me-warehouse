package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程表
 */
@Data
@Entity
@Table(name = "tms_type_course")
public class TmsTypeCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程表
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程代码
     */
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * 项目类型id
     */
    @Column(name = "tms_kind_type_id", nullable = false)
    private Integer tmsKindTypeId;

    /**
     * 课程类型 1 专业课   2 公共课
     */
    @Column(name = "kc_type")
    private Integer kcType;

    /**
     * 课程阶段  1 本科  0 专科
     */
    @Column(name = "kc_stage")
    private Integer kcStage;

    /**
     * 课程名称
     */
    @Column(name = "kc_name", nullable = false)
    private String kcName;

    /**
     * 1审核 正常  0 审核 未通过
     */
    @Column(name = "locked", nullable = false)
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

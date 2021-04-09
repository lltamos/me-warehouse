package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 试卷包
 */
@Data
@Entity
@Table(name = "tms_test_package")
public class TmsTestPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 试卷包名称
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * 所属项目
     */
    @Column(name = "tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 课程id
     */
    @Column(name = "tms_course_type_id")
    private Integer tmsCourseTypeId;

    /**
     * 专业id
     */
    @Column(name = "tms_subject_type_id")
    private Integer tmsSubjectTypeId;

    /**
     * 审核状态 0未审核 1已审核
     */
    @Column(name = "locked")
    private String locked;

    /**
     * 38历年真题 37模拟试卷 62考前押题 61易错考题
     */
    @Column(name = "paper_type")
    private String paperType;

    /**
     * 年份
     */
    @Column(name = "tyear")
    private String tyear;

    /**
     * 缩略图
     */
    @Column(name = "img")
    private String img;

    /**
     * 试卷包现价
     */
    @Column(name = "real_price")
    private String realPrice;

    /**
     * 原价
     */
    @Column(name = "sale_price")
    private String salePrice;

    /**
     * 试卷包简介
     */
    @Column(name = "summary")
    private String summary;

    @Column(name = "ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @Column(name = "utime")
    private Date utime;

}

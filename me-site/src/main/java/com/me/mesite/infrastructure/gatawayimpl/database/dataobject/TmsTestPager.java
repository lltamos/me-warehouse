package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "tms_test_pager")
public class TmsTestPager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 项目id
     */
    private Integer tmsKindTypeId;

    /**
     * 类型 38历年真题 37模拟试卷 62考前押题 61易错考题
     */
    private Integer paperType;

    /**
     * 专业
     */
    private Integer tmsSubjectTypeId;
    /**
     * 课程id
     */
    private Integer tmsCourseTypeId;


    /**
     * 章id
     */
    private Integer tmsChapterTypeId;

    /**
     * 节id
     */
    private Integer tmsSectionTypeId;

    private Integer provinceId;

    /**
     * 年份
     */
    private String tyear;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String img;

    /**
     * 通过分数
     */
    private Integer passmark;

    /**
     * 考试时间（分钟）
     */
    private Integer duration;

    /**
     * 描述
     */
    private String summary;

    /**
     * 1自定义 2后台随机
     */
    private String pattern;

    /**
     * 0锁定 1正常
     */
    private Integer locked;

    private Date ctime;

    /**
     * 更新时间
     */
    private Date utime;

}

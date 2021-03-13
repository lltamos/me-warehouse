package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 试题表
 */
@Entity(name = "tms_question")
@Data
public class TmsQuestion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 试题题库id
     */
    private Integer tmsQuestionRepsId;

    /**
     * 年份
     */
    private String tyear;

    /**
     * 项目类型
     */
    private Integer tmsKindTypeId;

    /**
     * 课程ID
     */
    private Integer tmsCourseTypeId;

    /**
     * 章ID
     */
    private Integer tmsChapterTypeId;

    /**
     * 节ID
     */
    private Integer tmsSectionTypeId;

    /**
     * 省份ID
     */
    private Integer provinceId;

    /**
     * 题型：0.单选题、1.多选题、2.判断题、3.填空题、4.主观题 5.组合题
     */
    private Integer txId;

    /**
     * 题干
     */
    private String tigan;

    /**
     * 图片
     */
    private String img;

    private Integer timao;

    /**
     * 备选项
     */
    private String options;

    /**
     * 答案解析
     */
    private String analyse;

    /**
     * 备选项的长度
     */
    private Integer optLength;

    /**
     * 是否审核通过
     */
    private Integer locked;

    /**
     * 答案
     */
    private String answer;

    /**
     * 更新时间
     */
    private Date utime;

    /**
     * 添加时间
     */
    private Date ctime;

}

package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 章
 */
@Entity(name = "tms_chapter_type")
@Data
public class TmsChapterType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 章节名称
     */
    private String name;

    /**
     * 课程id
     */
    private Integer tmsCourseTypeId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 1正常 0未审核
     */
    private Integer locked;

    /**
     * 添加时间
     */
    private Date ctime;

    /**
     * 更新时间
     */
    private Date utime;

}

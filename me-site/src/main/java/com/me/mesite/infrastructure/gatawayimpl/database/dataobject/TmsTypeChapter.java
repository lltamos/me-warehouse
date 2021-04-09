package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程下的章
 */
@Data
@Entity
@Table(name = "tms_type_chapter")
public class TmsTypeChapter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 章节名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 课程id
     */
    @Column(name = "tms_course_type_id", nullable = false)
    private Integer tmsCourseTypeId;

    /**
     * 排序
     */
    @Column(name = "rank", nullable = false)
    private Integer rank;

    /**
     * 1正常 0未审核
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

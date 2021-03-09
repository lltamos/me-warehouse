package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 专业表
 */
@Entity(name = "tms_subject_type")
@Data
public class TmsSubjectType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 项目id
     */
    private Integer kindTypeId;


    /**
     * 阶段1 本科 0 专科
     */
    private Integer stage;

    /**
     * 专业代码
     */
    private String code;

    /**
     * 省份id
     */
    private Integer proid;

    /**
     * 主考院校
     */
    private Integer msid;

    /**
     * 是否锁定
     */
    private Integer locked;

    /**
     * 增加时间
     */
    private Date ctime;

    /**
     * 更新时间
     */
    private Date utime;

}

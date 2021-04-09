package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 专业表
 */
@Data
@Entity
@Table(name = "tms_type_subject")
public class TmsTypeSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 项目id
     */
    @Column(name = "tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 阶段1 本科 0 专科
     */
    @Column(name = "stage")
    private Integer stage;

    /**
     * 专业代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 省份id
     */
    @Column(name = "proid")
    private Integer proid;

    /**
     * 主考院校
     */
    @Column(name = "msid")
    private Integer msid;

    /**
     * 是否锁定
     */
    @Column(name = "locked")
    private Integer locked;

    /**
     * 增加时间
     */
    @Column(name = "ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @Column(name = "utime")
    private Date utime;

}

package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学院-项目-专业/专业等级分类表
 */
@Data
@Entity
@Table(name = "tms_type_kind")
public class TmsTypeKind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型表
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型姓名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 父级id
     */
    @Column(name = "pid", nullable = false)
    private Integer pid;

    /**
     * 排序
     */
    @Column(name = "rank", nullable = false)
    private Integer rank;

    /**
     * 1 正常  0删除
     */
    @Column(name = "locked", nullable = false)
    private Integer locked;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "ctime", nullable = false)
    private Date ctime;

    @Column(name = "utime")
    private Date utime;

}

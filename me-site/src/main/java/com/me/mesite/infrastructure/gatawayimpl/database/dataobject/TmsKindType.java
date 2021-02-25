package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 项目分类表
 */
@Entity(name = "tms_kind_type")
@Data
public class TmsKindType {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 父id
     */
    private Integer pid;
    /**
     * 排序
     */
    private Integer sort;

    private Integer locked;

    private String remark;

    private Date ctime;

    private Date utime;




}

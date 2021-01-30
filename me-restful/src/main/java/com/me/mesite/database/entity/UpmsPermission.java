package com.me.mesite.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * upms_permission
 * @author 
 */
@Entity(name="upms_permission")
@Data
public class UpmsPermission implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    private String parameter;

    /**
     * 用户标识
     */
    private String userAgent;

    /**
     * IP地址
     */
    private String ip;

    private String result;

    /**
     * 权限值
     */
    private String permissions;

    private static final long serialVersionUID = 1L;
}
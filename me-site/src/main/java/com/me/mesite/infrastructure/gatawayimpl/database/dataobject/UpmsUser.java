package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 *
 * @author llt
 */
@Entity(name="upms_user")
@Data
public class UpmsUser {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 帐号
     */
    private String username;

    /**
     * 密码MD5(密码+盐)
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 状态(0:正常,1:锁定)
     */
    private Byte locked;

    /**
     * 创建时间
     */
    private Date ctime;

    private Date utime;


}
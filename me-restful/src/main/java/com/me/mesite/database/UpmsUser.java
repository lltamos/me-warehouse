package com.me.mesite.database;

import java.io.Serializable;
import lombok.Data;

/**
 * upms_user
 * @author llt
 */
@Data
public class UpmsUser implements Serializable {
    /**
     * 编号
     */
    private Integer userId;

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
    private Long ctime;

    private static final long serialVersionUID = 1L;
}
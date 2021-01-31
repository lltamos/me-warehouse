package com.me.mesite.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class MeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 密码SALT
     */
    private String salt;

    private String locale;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 标签
     */
    private String tags;

    /**
     * 邮箱是否为已验证
     */
    private Integer emailVerified;

    /**
     * 是否初始化设置的，未初始化的可以设置邮箱、昵称。
     */
    private Integer setup;

    /**
     * 用户角色
     */
    private Integer roleId;

    /**
     * 是否被禁止
     */
    private Integer locked;

    /**
     * 帐号锁定期限
     */
    private Long lockDeadline;

    /**
     * 实名认证时间
     */
    private Long approvalTime;

    /**
     * 实名认证状态
     */
    private Integer approvalStatus;


    /**
     * 注册时间
     */
    private Long ctime;

    /**
     * 最后更新时间
     */
    private Long utime;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 用户uuid
     */
    private String uuid;

    /**
     * 是否人脸注册过
     */
    private Integer faceRegistered;

}

package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_trainee")
public class UpmsTrainee extends Model<UpmsTrainee> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户uuid
     */
    @TableField("uuid")
    private String uuid;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 地区
     */
    @TableField("locale")
    private String locale;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 标签
     */
    @TableField("tags")
    private String tags;

    /**
     * 是否初始化设置的，未初始化的可以设置邮箱、昵称。
     */
    @TableField("setup")
    private Integer setup;

    /**
     * 是否被禁止
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 实名认证时间
     */
    @TableField("approval_time")
    private Long approvalTime;

    /**
     * 实名认证状态
     */
    @TableField("approval_status")
    private Integer approvalStatus;

    /**
     * 注册时间
     */
    @TableField("ctime")
    private LocalDateTime ctime;

    /**
     * 最后更新时间
     */
    @TableField("utime")
    private LocalDateTime utime;

    /**
     * 角色
     */
    @TableField("role_id")
    private Integer roleId;

    @TableField("nick_name")
    private String nickName;

    @TableField("real_name")
    private String realName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

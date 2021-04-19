package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_user")
public class UpmsUser extends Model<UpmsUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 帐号
     */
    @TableField("username")
    private String username;

    /**
     * 密码MD5(密码+盐)
     */
    @TableField("password")
    private String password;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 状态(0:正常,1:锁定)
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Date ctime;

    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

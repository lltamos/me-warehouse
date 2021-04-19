package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_role")
public class UpmsRole extends Model<UpmsRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色标题
     */
    @TableField("title")
    private String title;

    /**
     * 角色描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Long ctime;

    /**
     * 排序
     */
    @TableField("orders")
    private Long orders;

    @TableField("base_path")
    private String basePath;

    @TableField("ip")
    private String ip;

    @TableField("method")
    private String method;

    @TableField("parameter")
    private String parameter;

    @TableField("permissions")
    private String permissions;

    @TableField("result")
    private String result;

    @TableField("spend_time")
    private Integer spendTime;

    @TableField("start_time")
    private Long startTime;

    @TableField("uri")
    private String uri;

    @TableField("url")
    private String url;

    @TableField("user_agent")
    private String userAgent;

    @TableField("username")
    private String username;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

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
 * 权限
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_permission")
public class UpmsPermission extends Model<UpmsPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属系统
     */
    @TableField("system_id")
    private Integer systemId;

    /**
     * 所属上级
     */
    @TableField("pid")
    private Integer pid;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 类型(1:目录,2:菜单,3:按钮)
     */
    @TableField("type")
    private Integer type;

    /**
     * 权限值
     */
    @TableField("permission_value")
    private String permissionValue;

    /**
     * 路径
     */
    @TableField("uri")
    private String uri;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 状态(0:禁止,1:正常)
     */
    @TableField("status")
    private Integer status;

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

    @TableField("description")
    private String description;

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

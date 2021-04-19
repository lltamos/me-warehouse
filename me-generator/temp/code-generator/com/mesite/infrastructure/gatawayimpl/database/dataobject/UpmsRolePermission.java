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
 * 角色权限关联表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_role_permission")
public class UpmsRolePermission extends Model<UpmsRolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色编号
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 权限编号
     */
    @TableField("permission_id")
    private Integer permissionId;

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

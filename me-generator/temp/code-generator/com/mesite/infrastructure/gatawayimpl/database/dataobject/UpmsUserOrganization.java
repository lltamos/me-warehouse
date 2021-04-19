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
 * 用户组织关联表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_user_organization")
public class UpmsUserOrganization extends Model<UpmsUserOrganization> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 组织编号
     */
    @TableField("organization_id")
    private Integer organizationId;

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

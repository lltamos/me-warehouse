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
 * 操作日志
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("upms_log")
public class UpmsLog extends Model<UpmsLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作描述
     */
    @TableField("description")
    private String description;

    /**
     * 操作用户
     */
    @TableField("username")
    private String username;

    /**
     * 操作时间
     */
    @TableField("start_time")
    private Long startTime;

    /**
     * 消耗时间
     */
    @TableField("spend_time")
    private Integer spendTime;

    /**
     * 根路径
     */
    @TableField("base_path")
    private String basePath;

    /**
     * URI
     */
    @TableField("uri")
    private String uri;

    /**
     * URL
     */
    @TableField("url")
    private String url;

    /**
     * 请求类型
     */
    @TableField("method")
    private String method;

    @TableField("parameter")
    private String parameter;

    /**
     * 用户标识
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * IP地址
     */
    @TableField("ip")
    private String ip;

    @TableField("result")
    private String result;

    /**
     * 权限值
     */
    @TableField("permissions")
    private String permissions;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

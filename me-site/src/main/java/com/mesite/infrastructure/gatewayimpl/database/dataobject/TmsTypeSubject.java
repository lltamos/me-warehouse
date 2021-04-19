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
 * 专业表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_subject")
public class TmsTypeSubject extends Model<TmsTypeSubject> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 项目id
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 阶段1 本科 0 专科
     */
    @TableField("stage")
    private Integer stage;

    /**
     * 专业代码
     */
    @TableField("code")
    private String code;

    /**
     * 省份id
     */
    @TableField("proid")
    private Integer proid;

    /**
     * 主考院校
     */
    @TableField("msid")
    private Integer msid;

    /**
     * 是否锁定
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 增加时间
     */
    @TableField("ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

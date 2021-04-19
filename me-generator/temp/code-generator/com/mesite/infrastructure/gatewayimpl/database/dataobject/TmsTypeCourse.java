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
 * 课程表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_course")
public class TmsTypeCourse extends Model<TmsTypeCourse> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程代码
     */
    @TableField("code")
    private String code;

    /**
     * 项目类型id
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 课程类型 1 专业课   2 公共课
     */
    @TableField("kc_type")
    private Integer kcType;

    /**
     * 课程阶段  1 本科  0 专科
     */
    @TableField("kc_stage")
    private Integer kcStage;

    /**
     * 课程名称
     */
    @TableField("kc_name")
    private String kcName;

    /**
     * 1审核 正常  0 审核 未通过
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 添加时间
     */
    @TableField("ctime")
    private LocalDateTime ctime;

    /**
     * 更新时间
     */
    @TableField("utime")
    private LocalDateTime utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

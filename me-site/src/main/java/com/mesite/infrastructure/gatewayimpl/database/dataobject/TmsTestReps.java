package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 试题库
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_reps")
public class TmsTestReps extends Model<TmsTestReps> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    /**
     * 所属项目 都是tms_kind_type表
     */
    @TableField("tms_course_type_id")
    private Integer tmsCourseTypeId;

    @TableField("tms_course_type_str")
    private String tmsCourseTypeStr;

    /**
     * 所属学院
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    @TableField("tms_kind_type_str")
    private String tmsKindTypeStr;

    @TableField("locked")
    private Integer locked;

    @TableField("ctime")
    private LocalDateTime ctime;

    @TableField("utime")
    private LocalDateTime utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

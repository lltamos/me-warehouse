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
 * 专业和课程关联表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_subject_course_ship")
public class TmsTypeSubjectCourseShip extends Model<TmsTypeSubjectCourseShip> {

    private static final long serialVersionUID = 1L;

    /**
     * 专业课程
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专业id
     */
    @TableField("tms_subject_type_id")
    private Integer tmsSubjectTypeId;

    /**
     * 课程id
     */
    @TableField("tms_course_type_id")
    private Integer tmsCourseTypeId;

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

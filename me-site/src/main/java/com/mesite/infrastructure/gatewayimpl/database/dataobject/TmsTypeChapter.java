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
 * 课程下的章
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_chapter")
public class TmsTypeChapter extends Model<TmsTypeChapter> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 章节名称
     */
    @TableField("name")
    private String name;

    /**
     * 课程id
     */
    @TableField("tms_course_type_id")
    private Integer tmsCourseTypeId;

    /**
     * 排序
     */
    @TableField("rank")
    private Integer rank;

    /**
     * 1正常 0未审核
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 添加时间
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

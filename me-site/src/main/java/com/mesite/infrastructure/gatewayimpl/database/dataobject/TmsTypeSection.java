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
 * 课程下的章下面的节
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_section")
public class TmsTypeSection extends Model<TmsTypeSection> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 节名
     */
    @TableField("SectionName")
    private String sectionname;

    /**
     * 章id
     */
    @TableField("tms_type_chapter_id")
    private Integer tmsTypeChapterId;

    /**
     * 排序
     */
    @TableField("ranked")
    private Integer ranked;

    @TableField("locked")
    private Integer locked;

    @TableField("ctime")
    private Date ctime;

    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

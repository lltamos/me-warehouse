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

/**
 * <p>
 * 随堂资料，随堂讲义
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cur_course_docs")
public class CurCourseDocs extends Model<CurCourseDocs> {

    private static final long serialVersionUID = 1L;

    /**
     * 随堂资料 讲义表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1 直播  2点播   3课程资料
     */
    @TableField("course_type")
    private Integer courseType;

    /**
     * 视频章节id /课程id
     */
    @TableField("section_id")
    private Integer sectionId;

    /**
     * 课堂资料讲义名称
     */
    @TableField("file_name")
    private String fileName;

    /**
     * 地址
     */
    @TableField("file_path")
    private String filePath;

    /**
     * 1资料 2讲义 3课程资料
     */
    @TableField("doc_type")
    private Integer docType;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private String addTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

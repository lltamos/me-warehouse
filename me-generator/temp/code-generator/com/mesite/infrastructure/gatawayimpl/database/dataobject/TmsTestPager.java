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
 * 试卷
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_pager")
public class TmsTestPager extends Model<TmsTestPager> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目id
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 类型 38历年真题 37模拟试卷 62考前押题 61易错考题
     */
    @TableField("paper_type")
    private Integer paperType;

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
     * 章id
     */
    @TableField("tms_chapter_type_id")
    private Integer tmsChapterTypeId;

    /**
     * 节id
     */
    @TableField("tms_section_type_id")
    private Integer tmsSectionTypeId;

    @TableField("province_id")
    private Integer provinceId;

    /**
     * 年份
     */
    @TableField("tyear")
    private String tyear;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 封面
     */
    @TableField("img")
    private String img;

    /**
     * 通过分数
     */
    @TableField("passmark")
    private Integer passmark;

    /**
     * 考试时间（分钟）
     */
    @TableField("duration")
    private Integer duration;

    /**
     * 描述
     */
    @TableField("summary")
    private String summary;

    /**
     * 1自定义 2后台随机
     */
    @TableField("pattern")
    private Integer pattern;

    /**
     * 0锁定 1正常
     */
    @TableField("locked")
    private Integer locked;

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

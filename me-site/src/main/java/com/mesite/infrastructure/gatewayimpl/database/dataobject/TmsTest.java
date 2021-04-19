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
 * 试题表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test")
public class TmsTest extends Model<TmsTest> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 试题题库id
     */
    @TableField("tms_test_reps_id")
    private Integer tmsTestRepsId;

    /**
     * 题干
     */
    @TableField("tigan")
    private String tigan;

    /**
     * 备选项
     */
    @TableField("options")
    private String options;

    /**
     * 答案
     */
    @TableField("answer")
    private String answer;

    /**
     * 图片
     */
    @TableField("img")
    private String img;

    /**
     * 题型：0.单选题、1.多选题、2.判断题、3.填空题、4.主观题 5.组合题
     */
    @TableField("tx_id")
    private Integer txId;

    /**
     * 答案解析
     */
    @TableField("analyse")
    private String analyse;

    /**
     * 备选项的长度
     */
    @TableField("opt_size")
    private Integer optSize;

    /**
     * 年份
     */
    @TableField("tyear")
    private String tyear;

    /**
     * 项目类型
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 课程ID
     */
    @TableField("tms_course_type_id")
    private Integer tmsCourseTypeId;

    /**
     * 章ID
     */
    @TableField("tms_chapter_type_id")
    private Integer tmsChapterTypeId;

    /**
     * 节ID
     */
    @TableField("tms_section_type_id")
    private Integer tmsSectionTypeId;

    /**
     * 省份ID
     */
    @TableField("province_id")
    private Integer provinceId;

    /**
     * 是否审核通过
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

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
 * 试卷包
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_package")
public class TmsTestPackage extends Model<TmsTestPackage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 试卷包名称
     */
    @TableField("title")
    private String title;

    /**
     * 所属项目
     */
    @TableField("tms_kind_type_id")
    private Integer tmsKindTypeId;

    /**
     * 课程id
     */
    @TableField("tms_course_type_id")
    private Integer tmsCourseTypeId;

    /**
     * 专业id
     */
    @TableField("tms_subject_type_id")
    private Integer tmsSubjectTypeId;

    /**
     * 审核状态 0未审核 1已审核
     */
    @TableField("locked")
    private String locked;

    /**
     * 38历年真题 37模拟试卷 62考前押题 61易错考题
     */
    @TableField("paper_type")
    private String paperType;

    /**
     * 年份
     */
    @TableField("tyear")
    private String tyear;

    /**
     * 缩略图
     */
    @TableField("img")
    private String img;

    /**
     * 试卷包现价
     */
    @TableField("real_price")
    private String realPrice;

    /**
     * 原价
     */
    @TableField("sale_price")
    private String salePrice;

    /**
     * 试卷包简介
     */
    @TableField("summary")
    private String summary;

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

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
 * 高校学校
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_school")
public class TmsTypeSchool extends Model<TmsTypeSchool> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;

    @TableField("school_name")
    private String schoolName;

    @TableField("school_describe")
    private String schoolDescribe;

    @TableField("school_property")
    private String schoolProperty;

    @TableField("school_brief")
    private String schoolBrief;

    @TableField("school_details")
    private String schoolDetails;

    @TableField("school_genre")
    private String schoolGenre;

    @TableField("school_province")
    private String schoolProvince;

    @TableField("school_city")
    private String schoolCity;

    @TableField("school_delete")
    private Integer schoolDelete;

    @TableField("school_province_id")
    private String schoolProvinceId;

    @TableField("school_city_id")
    private String schoolCityId;

    @TableField("school_create_time")
    private LocalDateTime schoolCreateTime;

    @TableField("kind")
    private String kind;


    @Override
    protected Serializable pkVal() {
        return this.schoolId;
    }

}

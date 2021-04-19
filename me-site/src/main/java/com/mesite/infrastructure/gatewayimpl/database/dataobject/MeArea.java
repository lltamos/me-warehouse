package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_area")
public class MeArea extends Model<MeArea> {

    private static final long serialVersionUID = 1L;

    /**
     * 索引ID
     */
    @TableId(value = "area_id", type = IdType.AUTO)
    private Integer areaId;

    /**
     * 地区名称
     */
    @TableField("area_name")
    private String areaName;

    /**
     * 地区父ID
     */
    @TableField("area_parent_id")
    private Integer areaParentId;

    /**
     * 排序
     */
    @TableField("area_sort")
    private Integer areaSort;

    /**
     * 地区深度，从1开始
     */
    @TableField("area_deep")
    private Integer areaDeep;

    /**
     * 1 正常 0删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 1 激活  0未激活
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("creat_time")
    private String creatTime;


    @Override
    protected Serializable pkVal() {
        return this.areaId;
    }

}

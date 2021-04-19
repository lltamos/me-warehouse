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
 * 学院-项目-专业/专业等级分类表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_type_kind")
public class TmsTypeKind extends Model<TmsTypeKind> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型姓名
     */
    @TableField("name")
    private String name;

    /**
     * 父级id
     */
    @TableField("pid")
    private Integer pid;

    /**
     * 排序
     */
    @TableField("rank")
    private Integer rank;

    /**
     * 1 正常  0删除
     */
    @TableField("locked")
    private Integer locked;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Date ctime;

    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

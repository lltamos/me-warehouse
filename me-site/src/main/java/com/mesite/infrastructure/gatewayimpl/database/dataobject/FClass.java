package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("f_class")
public class FClass extends Model<FClass> {

    private static final long serialVersionUID = 1L;

    @TableField("f_id")
    private Integer fId;

    @TableField("f_type")
    private Integer fType;

    @TableField("f_name")
    private String fName;

    @TableField("f_shortname")
    private String fShortname;

    @TableField("f_desc")
    private String fDesc;

    @TableField("f_orders")
    private Integer fOrders;

    @TableField("f_ispass")
    private Integer fIspass;

    @TableField("f_delete")
    private Integer fDelete;

    @TableField("f_addtime")
    private Date fAddtime;

    @TableField("f_updatetime")
    private Date fUpdatetime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

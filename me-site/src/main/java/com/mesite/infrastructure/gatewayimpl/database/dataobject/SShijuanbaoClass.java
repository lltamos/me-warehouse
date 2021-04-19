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
 * 试卷包班型关系管理
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_shijuanbao_class")
public class SShijuanbaoClass extends Model<SShijuanbaoClass> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    /**
     * 试卷包id
     */
    @TableField("s_bao_id")
    private Integer sBaoId;

    /**
     * 班型id
     */
    @TableField("s_class_id")
    private Integer sClassId;


    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

}

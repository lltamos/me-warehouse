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
 * 班型资料表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cur_classes_doc")
public class CurClassesDoc extends Model<CurClassesDoc> {

    private static final long serialVersionUID = 1L;

    /**
     * 班型资料表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 班型id
     */
    @TableField("classes_id")
    private Integer classesId;

    /**
     * 资料id
     */
    @TableField("doc_id")
    private Integer docId;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private LocalDateTime addTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

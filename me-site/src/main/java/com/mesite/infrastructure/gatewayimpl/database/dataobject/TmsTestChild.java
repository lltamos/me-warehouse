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
 * 子试题表
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_child")
public class TmsTestChild extends Model<TmsTestChild> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 试题Id
     */
    @TableField("tms_test_id")
    private Integer tmsTestId;

    /**
     * 题型：0.单选题、1.多选题、2.判断题、3.填空题、4.主观题
     */
    @TableField("tx_id")
    private Integer txId;

    /**
     * 题干
     */
    @TableField("tigan")
    private String tigan;

    /**
     * 答案
     */
    @TableField("answer")
    private String answer;

    /**
     * 备选项
     */
    @TableField("options")
    private String options;

    /**
     * 备选项数量
     */
    @TableField("opt_size")
    private Integer optSize;

    /**
     * 答案解析
     */
    @TableField("analyse")
    private String analyse;

    /**
     * 是否审核通过
     */
    @TableField("lockd")
    private Integer lockd;

    /**
     * 添加时间
     */
    @TableField("ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

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
 * 试题和试卷的关联关系
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_paper_ship")
public class TmsTestPaperShip extends Model<TmsTestPaperShip> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题型名称
     */
    @TableField("name")
    private String name;

    /**
     * 0单项选择 1多项选择 2判断题 3填空题 4主观题 5.组合题
     */
    @TableField("tx_id")
    private Integer txId;

    /**
     * 试卷Id
     */
    @TableField("tms_test_paper_id")
    private Integer tmsTestPaperId;

    /**
     * 试题的ID 逗号分隔
     */
    @TableField("tms_test_content")
    private String tmsTestContent;

    /**
     * 每题分数
     */
    @TableField("mark")
    private Integer mark;

    /**
     * 题型描述
     */
    @TableField("description")
    private String description;

    /**
     * 题量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 排序
     */
    @TableField("rank")
    private Integer rank;

    @TableField("ctime")
    private Date ctime;

    @TableField("utime")
    private Date utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

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
 * 试卷包和试卷的绑定关系
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tms_test_paper_packge_ship")
public class TmsTestPaperPackgeShip extends Model<TmsTestPaperPackgeShip> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 试卷包id
     */
    @TableField("tms_test_packge_id")
    private Integer tmsTestPackgeId;

    /**
     * 试卷Id
     */
    @TableField("tms_test_paper_id")
    private Integer tmsTestPaperId;

    /**
     * 试卷类型
     */
    @TableField("paper_type")
    private String paperType;

    /**
     * 排序
     */
    @TableField("rank")
    private Integer rank;

    @TableField("ctime")
    private LocalDateTime ctime;

    @TableField("utime")
    private LocalDateTime utime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

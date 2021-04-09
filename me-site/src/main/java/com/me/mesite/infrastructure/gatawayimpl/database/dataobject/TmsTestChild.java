package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 子试题表
 */
@Data
@Entity
@Table(name = "tms_test_child")
public class TmsTestChild implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 试题Id
     */
    @Column(name = "tms_test_id", nullable = false)
    private Integer tmsTestId;

    /**
     * 题型：0.单选题、1.多选题、2.判断题、3.填空题、4.主观题
     */
    @Column(name = "tx_id", nullable = false)
    private Integer txId;

    /**
     * 题干
     */
    @Column(name = "tigan")
    private String tigan;

    /**
     * 答案
     */
    @Column(name = "answer")
    private String answer;

    /**
     * 备选项
     */
    @Column(name = "options")
    private String options;

    /**
     * 备选项数量
     */
    @Column(name = "opt_size")
    private Integer optSize;

    /**
     * 答案解析
     */
    @Column(name = "analyse")
    private String analyse;

    /**
     * 是否审核通过
     */
    @Column(name = "lockd")
    private Integer lockd;

    /**
     * 添加时间
     */
    @Column(name = "ctime")
    private Date ctime;

    /**
     * 更新时间
     */
    @Column(name = "utime")
    private Date utime;

}

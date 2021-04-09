package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 试题和试卷的关联关系
 */
@Data
@Entity
@Table(name = "tms_test_paper_ship")
public class TmsTestPaperShip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 题型名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 0单项选择 1多项选择 2判断题 3填空题 4主观题 5.组合题
     */
    @Column(name = "tx_id")
    private Integer txId;

    /**
     * 试卷Id
     */
    @Column(name = "tms_test_paper_id")
    private Integer tmsTestPaperId;

    /**
     * 试题的ID 逗号分隔
     */
    @Column(name = "tms_test_content")
    private String tmsTestContent;

    /**
     * 每题分数
     */
    @Column(name = "mark")
    private Integer mark;

    /**
     * 题型描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 题量
     */
    @Column(name = "amount")
    private Integer amount;

    /**
     * 排序
     */
    @Column(name = "rank")
    private Integer rank;

    @Column(name = "ctime")
    private Date ctime;

    @Column(name = "utime")
    private Date utime;

}

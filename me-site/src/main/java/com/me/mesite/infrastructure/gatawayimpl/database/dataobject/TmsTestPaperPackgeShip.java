package com.me.mesite.infrastructure.gatawayimpl.database.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 试卷包和试卷的绑定关系
 */
@Data
@Entity
@Table(name = "tms_test_paper_packge_ship")
public class TmsTestPaperPackgeShip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 试卷包id
     */
    @Column(name = "tms_test_packge_id", nullable = false)
    private Integer tmsTestPackgeId;

    /**
     * 试卷Id
     */
    @Column(name = "tms_test_paper_id", nullable = false)
    private Integer tmsTestPaperId;

    /**
     * 试卷类型
     */
    @Column(name = "paper_type")
    private String paperType;

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

package com.mesite.module.tms.entity;

import com.mesite.domain.common.PageEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TmsSearchBo extends PageEntity {
    //项目筛选
    private Integer tmsKinId;

    //课程筛选
    private Integer courseId;

    //题型筛选
    private Integer txid;

    //题库筛选
    private Integer testRepsId = 9999;

    //关键字
    private String key;

}

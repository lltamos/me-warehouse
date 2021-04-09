package com.me.mesite.module.tms.entity;

import com.me.mesite.domain.common.PageEntity;
import lombok.Data;

@Data
public class TmsSearchBo extends PageEntity {
    //项目筛选
    private Integer tmsKinId;

    //课程筛选
    private Integer courseId;

    //题型筛选
    private Integer txid;

    private Integer testRepsId;

    private String key;

}

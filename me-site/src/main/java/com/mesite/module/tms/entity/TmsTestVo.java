package com.mesite.module.tms.entity;

import com.mesite.domain.common.Vo;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TmsTestVo extends TmsTest implements Vo {
    private String txStr;


    public static TmsTestVo covert(TmsTest tmsTest) {
        TmsTestVo vo = new TmsTestVo();
        if (tmsTest == null) {
            return vo;
        }
        BeanUtils.copyProperties(tmsTest, vo);
        return vo;
    }


}

package com.me.mesite.domain.vo;

import com.me.mesite.domain.common.Vo;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
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
        BeanUtils.copyProperties(tmsTest, vo);
        return vo;
    }
}

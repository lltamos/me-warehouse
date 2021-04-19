package com.mesite.module.tms.entity;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@EqualsAndHashCode(callSuper = true)
@Data
public class TmsTestPagerVo extends TmsTestPager {
    public void copy(TmsTestPager tmsTestPager) {
        BeanUtils.copyProperties(tmsTestPager, this);
    }
}

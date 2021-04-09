package com.me.mesite.domain.vo;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class TmsTestPagerVo extends TmsTestPager {
    public void copy(TmsTestPager tmsTestPager) {
        BeanUtils.copyProperties(tmsTestPager, this);
    }
}

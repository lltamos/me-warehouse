package com.me.mesite.module.tms.entity;

import com.google.common.collect.Lists;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperShip;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Data
public class PaperViewBo {
    /**
     * 类型 38历年真题 37模拟试卷 62考前押题 61易错考题
     */
    private Integer paperType;
    /**
     * 标题
     */
    private String title;

    /**
     * 通过分数
     */
    private Integer passmark;

    /**
     * 考试时间（分钟）
     */
    private Integer duration;
    /**
     * 描述
     */
    private String summary;

    /**
     * 试题
     */
    private List<TestViewBo> testLists = Lists.newArrayList();

    @Data
    private class TestViewBo {
        private Integer txId;
        private String name;
        private Integer mark;
        private Integer amount;
        private List<TmsTest> tmsTests;
    }


    public void setPagerInfo(TmsTestPager tmsTestPager) {
        this.duration = tmsTestPager.getDuration();
        this.passmark = tmsTestPager.getPassmark();
        this.paperType = tmsTestPager.getPaperType();
        this.summary = tmsTestPager.getSummary();
        this.title = tmsTestPager.getTitle();
    }


    public void setPagerTestItem(TmsTestPaperShip tmsTestPaperShip, List<TmsTest> tmsTests) {
        TestViewBo testViewBo = new TestViewBo();
        testViewBo.setTxId(tmsTestPaperShip.getTxId());
        testViewBo.setName(tmsTestPaperShip.getName());
        testViewBo.setAmount(tmsTestPaperShip.getAmount());
        testViewBo.setMark(tmsTestPaperShip.getMark());
        testViewBo.setTmsTests(tmsTests);
        testLists.add(testViewBo);
    }

}

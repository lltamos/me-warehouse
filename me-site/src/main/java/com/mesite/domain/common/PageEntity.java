package com.mesite.domain.common;

import com.mesite.common.validator.Assert;
import lombok.Data;

import java.util.Objects;

/**
 * @author zhangzhiwei
 * 分页需继承的类
 */
@Data
public class PageEntity {

    private Integer page = 1;

    private Integer limit = 15;

    private Integer pageType = 1;

    public <T> BasePage<T> parse() {
        BasePage<T> page = new BasePage<>(getPage(), getLimit());
        if (Objects.equals(0, pageType)) {
            page.setSize(500);
        }
        return page;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
        if (pageType == 0) {
            limit = 500;
        }
    }

    public Integer getLimit() {
        if (limit > 100 && 1 == pageType) {
            limit = 100;
        } else if (0 == pageType) {
            limit = 1000;
        }
        return limit;
    }

    public Integer getCelFrom() {
        if (pageType == 1) {
            Assert.before(getPage(), 0, "page must >0");
        }
        return pageType != 1 ? 0 : (getPage() - 1) * limit;
    }

    /**
     * 是否分页
     */
    public boolean isPageType() {
        return 1 == pageType;
    }

}

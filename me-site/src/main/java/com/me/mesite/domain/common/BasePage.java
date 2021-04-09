package com.me.mesite.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.mesite.domain.vo.TmsTestVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhiwei
 * 默认分页
 */
public class BasePage<T> implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    private List<T> list = new ArrayList<>();
    /**
     * 总数
     */
    private long totalRow = 0;

    /**
     * 每页显示条数，默认 15
     */
    private long pageSize = 15;

    /**
     * 当前页
     */
    private long pageNumber = 1;
    /**
     * 是否进行 count 查询
     */
    private boolean isSearchCount = true;

    /**
     * 额外数据
     */
    private Object extraData;


    public BasePage() {

    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public BasePage(long current, long size) {
        this(current, size, 0);
    }

    public BasePage(long current, long size, long total) {
        this(current, size, total, true);
    }

    public BasePage(long current, long size, boolean isSearchCount) {
        this(current, size, 0, isSearchCount);
    }

    public BasePage(long current, long size, long total, boolean isSearchCount) {
        if (current > 1) {
            this.pageNumber = current;
        }
        this.pageSize = size;
        this.totalRow = total;
        this.isSearchCount = isSearchCount;
    }


    @Override
    @JsonIgnore
    public List<T> getRecords() {
        return this.list;
    }

    public List<T> getList() {
        return this.list;
    }

    public long getTotalRow() {
        return this.totalRow;
    }

    public long getTotalPage() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    public long getPageSize() {
        return this.pageSize;
    }


    public long getPageNumber() {
        return this.pageNumber;
    }

    public boolean isFirstPage() {
        return this.pageNumber == 1L;
    }

    public boolean isLastPage() {
        return getTotal() == 0 || this.pageNumber == getTotalPage();
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public BasePage<T> setRecords(List<T> records) {
        this.list = records;
        return this;
    }

    @Override
    @JsonIgnore
    public long getTotal() {
        return this.totalRow;
    }

    @Override
    public BasePage<T> setTotal(long total) {
        this.totalRow = total;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public BasePage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return this.pageNumber;
    }

    @Override
    public BasePage<T> setCurrent(long current) {
        this.pageNumber = current;
        return this;
    }


    @Override
    @JsonIgnore
    public boolean isSearchCount() {
        if (totalRow < 0) {
            return false;
        }
        return isSearchCount;
    }

    public void setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
    }

    @Override
    @JsonIgnore
    public long getPages() {
        return getTotalPage();
    }

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }


    public BasePage<T> autoInitPageSelfArgsResponse(List data, Integer count) {


        this.setRecords(data);
        this.setTotal(count);
        return this;
    }

    public BasePage<T> autoInitPageSelfArgsResponse(List data) {
        this.setRecords(data);
        this.setTotal(data.size());
        return this;
    }

}

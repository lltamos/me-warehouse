package com.me.mesite.common.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public class Pagination extends RowBounds implements Serializable {
    private static final long serialVersionUID = 1L;
    private long total;
    private int size;
    private int current;
    private boolean searchCount;
    private boolean openSort;
    private boolean optimizeCountSql;
    private List<String> ascs;
    private List<String> descs;
    private boolean isAsc;
    private String orderByField;

    public Pagination() {
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.openSort = true;
        this.optimizeCountSql = true;
        this.isAsc = true;
    }

    public Pagination(int current, int size) {
        this(current, size, true);
    }

    public Pagination(int current, int size, boolean searchCount) {
        this(current, size, searchCount, true);
    }

    public Pagination(int current, int size, boolean searchCount, boolean openSort) {
        super(PageHelper.offsetCurrent(current, size), size);
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.openSort = true;
        this.optimizeCountSql = true;
        this.isAsc = true;
        if (current > 1) {
            this.current = current;
        }

        this.size = size;
        this.searchCount = searchCount;
        this.openSort = openSort;
    }

    public boolean hasPrevious() {
        return this.current > 1;
    }

    public boolean hasNext() {
        return (long)this.current < this.getPages();
    }

    public long getTotal() {
        return this.total;
    }

    public Pagination setTotal(long total) {
        this.total = total;
        return this;
    }

    public int getSize() {
        return this.size;
    }

    public Pagination setSize(int size) {
        this.size = size;
        return this;
    }

    public long getPages() {
        if (this.size == 0) {
            return 0L;
        } else {
            long pages = this.total / (long)this.size;
            if (this.total % (long)this.size != 0L) {
                ++pages;
            }

            return pages;
        }
    }

    public int getCurrent() {
        return this.current;
    }

    public Pagination setCurrent(int current) {
        this.current = current;
        return this;
    }

    @Transient
    public boolean isSearchCount() {
        return this.searchCount;
    }

    public Pagination setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
        return this;
    }

    /** @deprecated */
    @Deprecated
    @Transient
    public String getOrderByField() {
        return this.orderByField;
    }

    public Pagination setOrderByField(String orderByField) {
        if (StringUtils.isNotEmpty(orderByField)) {
            this.orderByField = orderByField;
        }

        return this;
    }

    @Transient
    public boolean isOpenSort() {
        return this.openSort;
    }

    public Pagination setOpenSort(boolean openSort) {
        this.openSort = openSort;
        return this;
    }

    @Transient
    public boolean isOptimizeCountSql() {
        return this.optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    @Transient
    public List<String> getAscs() {
        return this.orders(this.isAsc, this.ascs);
    }

    private List<String> orders(boolean condition, List<String> columns) {
        if (condition && StringUtils.isNotEmpty(this.orderByField)) {
            if (columns == null) {
                columns = new ArrayList();
            }

            if (!((List)columns).contains(this.orderByField)) {
                ((List)columns).add(this.orderByField);
            }
        }

        return (List)columns;
    }

    public Pagination setAscs(List<String> ascs) {
        this.ascs = ascs;
        return this;
    }

    @Transient
    public List<String> getDescs() {
        return this.orders(!this.isAsc, this.descs);
    }

    public Pagination setDescs(List<String> descs) {
        this.descs = descs;
        return this;
    }

    /** @deprecated */
    @Deprecated
    @Transient
    public boolean isAsc() {
        return this.isAsc;
    }

    public Pagination setAsc(boolean isAsc) {
        this.isAsc = isAsc;
        return this;
    }

    @Transient
    public int getOffset() {
        return super.getOffset();
    }

    @Transient
    public int getLimit() {
        return super.getLimit();
    }

    public String toString() {
        return "Pagination { total=" + this.total + " ,size=" + this.size + " ,pages=" + this.getPages() + " ,current=" + this.current + " }";
    }
}


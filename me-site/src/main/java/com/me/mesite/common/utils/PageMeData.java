package com.me.mesite.common.utils;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageMeData extends MeData<List> {
    private long total;
    private long limit;
    private long totalPages;
    private long currentLimit;
    private long currentPage;

    public static MeData springPageToPageResponse(Page page) {
        PageMeData pageMeData = new PageMeData();
        pageMeData.setTotal(page.getTotalElements());
        pageMeData.setData(page.getContent());
        pageMeData.setCurrentPage(page.getNumber());
        pageMeData.setCurrentLimit(page.getNumberOfElements());
        pageMeData.setTotalPages(page.getTotalPages());
        pageMeData.setLimit(page.getSize());
        return pageMeData;
    }


    public static MeData<List> autoInitPageSelfArgsResponse(List data, Integer total, Integer limit, Integer currentPage) {

        PageMeData pageMeData = new PageMeData();
        pageMeData.setTotal(total);
        pageMeData.setData(data);
        pageMeData.setCurrentPage(currentPage);
        pageMeData.setCurrentLimit(data.size());
        pageMeData.setTotalPages((long) Math.ceil(total / limit));
        pageMeData.setLimit(limit);
        return pageMeData;
    }


    public static void main(String[] args) {
        List<cn.hutool.db.Page> list = new ArrayList<>();
        MeData<List> listMeData = autoInitPageSelfArgsResponse(list, 1, 1, 1);
    }


}

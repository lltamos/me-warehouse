package com.me.mesite.common.utils;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@SuperBuilder
public class PageResponse extends Response<List> {
    private long total;
    private long limit;
    private long totalPages;
    private long currentLimit;
    private long currentPage;

    public static Response springPageToPageResponse(Page page) {

        return PageResponse.builder()
                .total(page.getTotalElements())
                .data(page.getContent())
                .currentLimit(page.getNumberOfElements())
                .limit(page.getSize())
                .totalPages(page.getTotalPages())
                .currentPage(page.getNumber()).build();
    }


    public static Response autoInitPageSelfArgsResponse(List data, Integer total, Integer limit, Integer currentPage) {
        return PageResponse.builder()
                .total(total)
                .data(data)
                .currentLimit(data.size())
                .limit(limit)
                .totalPages((long) Math.ceil(total / limit))
                .currentPage(currentPage).build();
    }


}

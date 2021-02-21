package com.me.mesite.common.utils;

import org.springframework.data.domain.Sort;

public class SortUtils {
    public static Sort buildASC(String row) {
        return Sort.by(Sort.Direction.ASC, row);
    }

    public static Sort buildDESC(String row) {
        return Sort.by(Sort.Direction.DESC, row);
    }
}

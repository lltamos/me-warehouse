package com.me.mesite.common.utils;

import lombok.Builder;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    //通用分页参数
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String SORT = "sort";
    private static final String TOKEN = "token";


    public static Param parseRequestBaseParam() {
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        Object sessionID = httpServletRequest.getSession().getId();
        Object pageObj = httpServletRequest.getAttribute(PAGE);
        Object limitObj = httpServletRequest.getAttribute(LIMIT);
        Param.ParamBuilder builder = Param.builder().sessionId(httpServletRequest.getRequestedSessionId());
        if (Tools.isNumber(pageObj)) {
            builder.page((Integer) pageObj);
        }
        if (Tools.isNumber(limitObj)) {
            builder.limit((Integer) limitObj);
        }
        return builder.build().init();
    }


    @Builder
    @Data
    public static class Param {
        Integer page;
        Integer limit;
        String token;
        /**
         * 'asc'
         * 'desc'
         */
        String sort;
        /**
         * 是否分页
         */
        boolean isPaged;
        String sessionId;


        public Param init() {
            if (page != null || limit != null) {
                this.isPaged = true;
            }
            return this;
        }

        /**
         * 计算db查询页码
         *
         * @return real page
         */
        public Integer getCelPage() {
            return isPaged ? page - 1 : null;
        }

        /**
         * @return 是否分页
         */
        public boolean isPaging() {
            return limit != null && page != null;
        }

        public Integer getCelFrom() {
            return isPaged ? getCelPage() * limit : null;
        }

    }


}

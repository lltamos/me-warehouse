package com.me.mesite.common.utils;

import com.p6spy.engine.spy.appender.MultiLineFormat;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;


public class PrettySqlMultiLineFormatP6SpyLogger extends MultiLineFormat {
    private static final Formatter FORMATTER = new BasicFormatterImpl();

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return !"".equals(sql.trim()) ? super.formatMessage(connectionId, now, elapsed, category, FORMATTER.format(prepared), FORMATTER.format(sql), url) : "";
    }
}

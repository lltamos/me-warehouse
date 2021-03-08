package com.me.mesite.module.tms.event;

import org.springframework.context.ApplicationEvent;

public class RefreshMsgEvent extends ApplicationEvent {

    private RefreshType refreshType = null;

    public RefreshMsgEvent(Object source) {
        super(source);
    }

    public enum RefreshType {
        //刷新系统通用配置换成字段
        Constant,
        Others
    }

    public RefreshMsgEvent build(RefreshType refreshType) {
        this.refreshType = refreshType;
        return this;
    }

    public RefreshType getRefreshType() {
        return refreshType;
    }
}

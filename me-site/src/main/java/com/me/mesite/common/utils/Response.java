package com.me.mesite.common.utils;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class Response {
    private Object data;

    public void checkResponse() {
    }

    public Object getDate() {
        return this.data;
    }
}

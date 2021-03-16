package com.me.mesite.common.utils;

import lombok.Data;

@Data
public abstract class MeData<T> {
    private T data;

    public void checkResponse() {
    }

    public T getDate() {
        return this.data;
    }
}

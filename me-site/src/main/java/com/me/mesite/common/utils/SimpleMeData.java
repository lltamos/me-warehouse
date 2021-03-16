package com.me.mesite.common.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleMeData<T> extends MeData<T> {

    public static <T> MeData<T> initSimpleResponse(T data) {
        SimpleMeData<T> meData = new SimpleMeData<>();
        meData.setData(data);
        return meData;
    }
}

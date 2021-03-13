package com.me.mesite.common.utils;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SimpleResponse extends Response {

    public static Response initSimpleResponse(Object data) {
        return SimpleResponse.builder().data(data).build();
    }
}

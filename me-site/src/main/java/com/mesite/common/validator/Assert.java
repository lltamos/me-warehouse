/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mesite.common.validator;

import cn.hutool.core.bean.BeanUtil;
import com.mesite.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * 数据校验
 *
 * @author lltamos
 * @email lltamos@outlook.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {


    private final static String MSG_NULL = "target is null";

    private final static String VALIDATE_FAIL = "validate is fail";


    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, MSG_NULL);
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }

    public static void after(@NotNull Integer target, @NotNull Integer compare, String message) {
        if (target > compare) {
            throw new RRException(message);
        }
    }

    public static void after(@NotNull Integer target, @NotNull Integer compare) {
        after(target, compare, VALIDATE_FAIL);
    }

    public static void before(@NotNull Integer target, @NotNull Integer compare, String message) {
        if (target < compare) {
            throw new RRException(message);
        }
    }

    public static void before(@NotNull Integer target, @NotNull Integer compare) {
        before(target, compare, VALIDATE_FAIL);
    }


    public static void notEmpty(Object t) {
        try {
            org.springframework.util.Assert.notEmpty(BeanUtil.beanToMap(t, false, true), "数据不能都为空");

        } catch (Exception e) {
            // TODO: handle exception
            throw new RRException(e.getMessage());

        }
    }

}

package com.me.mesite.common.annotation;

import java.lang.annotation.*;

/**
 * 忽略某个参数
 *
 * @author freeter 171998110@qq.com
 * @since 3.0.0 2018-08-12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MpIgnore {
 
}

package com.me.mesite.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.3.0 2017-03-08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface J2CacheEvit {
	 String value() default "";

}

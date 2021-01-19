package com.me.mesite.common.annotation;

import java.lang.annotation.*;

/**
 * like查询
 *
 * @author freeter 171998110@qq.com
 * @since 3.0.0 2018-08-12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MpLike {
	
	 /**
     * <p>
     * 真实查询的字段,填写属性名
     * </p>
     */
	String[] value() default {};
       	

}

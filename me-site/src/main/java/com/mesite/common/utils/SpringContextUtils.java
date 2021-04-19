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

package com.mesite.common.utils;

import com.mesite.common.config.White;
import com.mesite.common.validator.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Spring Context 工具类
 *
 * @author lltamos
 * @email lltamos@outlook.com
 * @date 2016年11月29日 下午11:45:51
 */
@Component
@Slf4j
public class SpringContextUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Value("${white:}")
    private String[] white;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
        White.whiteList = white;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }

    //发送事件
    public static void publishEvent(ApplicationEvent event) {
        Assert.isNull(event);
        Assert.isNull(applicationContext);
        log.info("SpringContextUtils Event validated  success");
        applicationContext.publishEvent(event);
        log.info("SpringContextUtils execute action [publish {} event] args :{} ", event.getClass().getName(), event.getSource());
    }

}
package com.qiuhuu.cloud.common.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取applicationContext ，静态变量保存，以便获取
 * @author : qiuhuu
 * @date : 2020-07-02 16-03
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware 接口的Con
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取存储在静态变量中的ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从applicationContext中获取Bean
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T)applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        return (T)applicationContext.getBean(clazz);
    }

    /**
     * 清除applicationContext
     */
    public static void cleanApplicationContext(){
        applicationContext = null;
    }

    /**
     * 检查applicationContext
     */
    private static void checkApplicationContext(){
        if (applicationContext == null){
            throw new IllegalStateException(
                    "applicationContext未注入"
            );
        }
    }
}

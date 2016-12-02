package org.manager.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by lei on 11/30/2016.
 */
public abstract class BeanProvider {
    private static ApplicationContext applicationContext;
    private BeanProvider(){}
    public static void initialize(WebApplicationContext applicationContext) {
        BeanProvider.applicationContext=applicationContext;
    }


    /**
     * Get Bean by clazz.
     *
     * @param clazz Class
     * @param <T>   class type
     * @return Bean instance
     */
    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        if (applicationContext == null) {
            return null;
        }
        return (T) applicationContext.getBean(beanId);
    }

}

package com.cloud.provider.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Created with IntelliJ IDEA.
 * @Description: cloud-micro-service
 * @Author: luhk
 * @Date: 2018-11-19
 * @Time: 10:31 AM
 * @Version: 1.0
 */
@Component
public class SpringUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    // 获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);

    }

    // 通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    protected Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class ownerClass = owner.getClass();
        Class[] argsClass = new Class[args.length];
        int i = 0;

        for(int j = args.length; i < j; ++i) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);
        return method.invoke(owner, args);
    }

    protected Object invokeMethod(String widgetName, String methodName, Object[] args) {
        Object result = null;
        Object clazz = getApplicationContext().getBean(widgetName);
        if (clazz != null) {
            try {
                result = this.invokeMethod((Object)clazz, methodName, args);
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

        return result;
    }
}

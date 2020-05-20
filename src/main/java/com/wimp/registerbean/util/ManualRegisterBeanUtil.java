package com.wimp.registerbean.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  手动注册benn工具类
 */
@Slf4j
public class ManualRegisterBeanUtil {

    /**
     * 注册bean方法
     * @param applicationContext spring容器对象
     * @param name bean名称
     * @param clazz 类型
     * @param args 参数
     * @param <T>
     * @return
     */
    public static <T> T registerBean(ConfigurableApplicationContext applicationContext,
                                     String name, Class<T> clazz, Object... args) {
        if(applicationContext.containsBean(name)){//判断是否已经存在
            Object bean = applicationContext.getBean(name);
            if(bean.getClass().isAssignableFrom(clazz)){
                return (T) bean;
            }else {
                throw new RuntimeException("this BeanName exists: "+name);
            }
        }

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        for(Object arg:args){//传递参数
            beanDefinitionBuilder.addConstructorArgValue(arg);
        }
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        //注册进入spring容器中
        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
        beanDefinitionRegistry.registerBeanDefinition(name,beanDefinition);
        return applicationContext.getBean(name,clazz);
    }
}

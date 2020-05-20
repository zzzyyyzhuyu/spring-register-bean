package com.wimp.registerbean.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  只可以被Import(xxx.class)方式注册
 *  扫描自定义注解mapper的类，并进行注册
 */
public class MapperAutoConfiguredMyBatisRegistrar implements
        ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {

    private ResourceLoader resourceLoader;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry beanDefinitionRegistry) {
        //使用自定义的扫描器 扫描mapper
        MyClassPathBeanDefinitionScanner scanner = new
                MyClassPathBeanDefinitionScanner(beanDefinitionRegistry, true);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();
        //指定所要扫描的包
        scanner.doScan("com.ztax.registerbean");
    }
}

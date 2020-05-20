package com.wimp.registerbean.registrar;

import com.wimp.registerbean.service.MyService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Map;

/**
 * @author zy
 * @date 2020/5/19
 * <p>
 *  注册bean（注册指定的某一个bean）,通过扫描器方式实现
 */
public class MyServiceImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        //扫描相关注解
        Map<String, Object> annotationAttributes = annotationMetadata
                .getAnnotationAttributes(ComponentScan.class.getName());
        String[] basePackages = (String[]) annotationAttributes.get("basePackages");

        //扫描类
        ClassPathBeanDefinitionScanner scanner =
                new ClassPathBeanDefinitionScanner(beanDefinitionRegistry, false);
        TypeFilter myServiceFilter = new AssignableTypeFilter(MyService.class);

        scanner.addIncludeFilter(myServiceFilter);
        scanner.scan(basePackages);


    }
}

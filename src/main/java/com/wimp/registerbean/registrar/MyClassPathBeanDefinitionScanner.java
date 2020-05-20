package com.wimp.registerbean.registrar;

import com.wimp.registerbean.annotation.Mapper;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  自定义的扫描器，扫描Mapper
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry,boolean useDefaultFilters){
        super(registry,useDefaultFilters);
    }

    /**
     *
     * 扫描器过滤器中 加入Mapper注解拦截
     */
    protected void registerFilters(){
        addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages){
        return super.doScan(basePackages);
    }
}

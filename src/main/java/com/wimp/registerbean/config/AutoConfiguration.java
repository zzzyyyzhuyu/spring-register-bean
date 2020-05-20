package com.wimp.registerbean.config;

import com.wimp.registerbean.registrar.MyServiceImportBeanDefinitionRegistrar;
import com.wimp.registerbean.registrar.MapperAutoConfiguredMyBatisRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  
 */
@Configuration
@ComponentScan("com.ztax.registerbean")
@Import({MyServiceImportBeanDefinitionRegistrar.class,MapperAutoConfiguredMyBatisRegistrar.class})
public class AutoConfiguration {

}

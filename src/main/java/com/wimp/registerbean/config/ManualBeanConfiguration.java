package com.wimp.registerbean.config;

import com.wimp.registerbean.bean.ManualBean;
import com.wimp.registerbean.bean.ManualDIBean;
import com.wimp.registerbean.util.ManualRegisterBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  
 */
@Slf4j
@Configuration
public class ManualBeanConfiguration {

    public ManualBeanConfiguration(ApplicationContext applicationContext){
        log.info("ManualBeanConfiguration init "+System.currentTimeMillis());
        registerManualBean((ConfigurableApplicationContext) applicationContext);
    }

    /**
     * 注册bean
     * @param applicationContext
     */
    private void registerManualBean(ConfigurableApplicationContext applicationContext) {
        ManualBean manual = ManualRegisterBeanUtil.registerBean(applicationContext, "manual",ManualBean.class);
        manual.print("test print manualBean");

        ManualDIBean manualDIBean = ManualRegisterBeanUtil.registerBean(applicationContext, "manualDIBean",
                ManualDIBean.class, "依赖OriginBean的自定义Bean");
        manualDIBean.print("test print manualDIBean");
    }


}

package com.wimp.registerbean.mapper;

import com.wimp.registerbean.config.AutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AutoConfiguration.class})
public class MapperTest {

    @Resource
    private MyMapper myMapper;

    @Test
    public void testMapper(){
        System.out.println(myMapper.getClass());
    }
}

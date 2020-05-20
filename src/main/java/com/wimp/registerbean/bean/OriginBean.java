package com.wimp.registerbean.bean;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  被依赖的类，spring注入
 */
@Component
public class OriginBean {
    private LocalDateTime time;

    public OriginBean() {
        time = LocalDateTime.now();
    }

    public String print(String msg) {
        return "[OriginBean] print msg: " + msg + ", time: " + time;
    }
}

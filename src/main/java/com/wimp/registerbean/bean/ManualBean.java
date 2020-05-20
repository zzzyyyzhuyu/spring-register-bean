package com.wimp.registerbean.bean;

import java.util.Random;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  
 */
public class ManualBean {
    private int id;

    public ManualBean() {
        Random random = new Random();
        id = random.nextInt(100);
    }

    public String print(String msg) {
        return "[ManualBean] print : " + msg + " id: " + id;
    }

}

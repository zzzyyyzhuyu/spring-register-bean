package com.wimp.registerbean.controller;

import com.wimp.registerbean.bean.ManualBean;
import com.wimp.registerbean.bean.ManualDIBean;
import com.wimp.registerbean.bean.OriginBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @date 2020/5/20
 * <p>
 *  
 */
@RestController
public class ShowController {
    @Resource
    private ManualBean manualBean;
    @Resource
    private ManualDIBean manualDIBean;
    @Autowired
    private OriginBean originBean;

    public ShowController() {
        System.out.println("ShowController init: " + System.currentTimeMillis());
    }

    @GetMapping(path = "show")
    public Map<String,String> show(String msg) {
        Map<String, String> result = new HashMap<>(8);
        result.put("manualBean", manualBean == null ? "null" : manualBean.print(msg));
        result.put("manualDIBean", manualDIBean == null ? "null" : manualDIBean.print(msg));
        result.put("originBean",originBean.print("originBean"));
        return result;
    }

}

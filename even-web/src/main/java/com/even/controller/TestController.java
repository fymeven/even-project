package com.even.controller;

import com.even.common.redis.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by even on 2017/12/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public void redis(){
        redisUtil.set("bar","test");
        String bar = (String) redisUtil.get("bar");
        String name="";
        if (redisUtil.exists("name")){
            name=(String)redisUtil.get("name");
        }
        System.out.println("bar:>>>"+bar);
        System.out.println("name:>>>"+name);
    }
}

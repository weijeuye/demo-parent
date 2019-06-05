package com.weason.demoweb.controller;

import com.alibaba.fastjson.JSON;
import com.weason.demo.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.netty.http.server.HttpServerRequest;

/**
 * @Author: lei.wei
 * @Date: 2019/6/4 16:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class controller {
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/test")
    public void test(HttpServerRequest request,String name){

        System.out.println(name);
        System.out.println(JSON.toJSON(redisUtil));
    }

}

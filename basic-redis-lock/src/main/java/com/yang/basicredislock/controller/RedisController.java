package com.yang.basicredislock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mu_Yi
 * @Date: 2020/5/24 23:21
 * @Version 1.0
 * @qq: 1411091515
 */

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public Object hello(){
        return redisTemplate.opsForValue().get("yang");
    }

}

package com.yang.basicredislock.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/14 20:06
 * @Version 1.0
 * @qq: 1411091515
 */

@Service
public class RedisSessionServiceImpl {


    @Autowired
    private RedissonClient redissonClient;

    public void redissionLockTest(){

        RLock lock = redissonClient.getLock("yang-1");
        lock.lock();
        try {

            System.out.println("主业务逻辑代码执行");

        } finally {
            // 确保进入到  finally 中进行释放掉.
            lock.unlock();
        }

    }

}

package com.iyang.netty.provider;

import com.iyang.netty.pinterface.HelloService;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:18
 * @Version 1.0
 * @qq: 1411091515
 */


public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String msg) {
        return msg == null ? "I am fine"  : msg + " ---> I am fine." ;
    }
}

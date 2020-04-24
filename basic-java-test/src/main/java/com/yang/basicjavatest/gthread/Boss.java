package com.yang.basicjavatest.gthread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/8 23:58
 * @Version 1.0
 * @qq: 1411091515
 */
public class Boss implements Runnable {

    private CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("老板正在等所有的工人干完活......");
        try {
            this.downLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("工人活都干完了，老板开始检查了！");
    }
}

package com.yang.basicjavatest.gthread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/8 23:57
 * @Version 1.0
 * @qq: 1411091515
 */
public class Worker implements Runnable {

    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }
    private void doWork(){
        System.out.println(this.name + "正在干活!");
    }

    @Override
    public void run() {
        this.doWork();
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch(InterruptedException ie){
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();

    }
}

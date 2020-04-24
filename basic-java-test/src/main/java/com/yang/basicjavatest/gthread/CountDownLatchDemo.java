package com.yang.basicjavatest.gthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/8 23:59
 * @Version 1.0
 * @qq: 1411091515
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);

        Worker w1 = new Worker(latch,"张三");
        Worker w2 = new Worker(latch,"李四");
        Worker w3 = new Worker(latch,"王二");

        Boss boss = new Boss(latch);

        executor.execute(boss);
        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);


        executor.shutdown();
    }

}




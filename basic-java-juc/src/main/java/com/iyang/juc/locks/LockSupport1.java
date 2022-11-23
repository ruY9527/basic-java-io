package com.iyang.juc.locks;

import java.util.concurrent.locks.LockSupport;

/***
 * @author: baoyang
 * @data: 2022/11/23
 * @desc:
 ***/
public class LockSupport1 {


    public static void main(String[] args) throws InterruptedException {

        System.out.println(1 & 1024);

        // 一直处理悬挂
        System.out.println("开始 park 方法");
        // LockSupport.park();
        LockSupport.unpark(Thread.currentThread());


        // Thread.sleep(1000);
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("结束 park 方法");

/*        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread park 开始");
                LockSupport.park();
                System.out.println("child thread park 结束");
            }
        });

        thread.start();
        Thread.sleep(1000);

        System.out.println("主线程开始解压");
        LockSupport.unpark(thread);*/

    }

}

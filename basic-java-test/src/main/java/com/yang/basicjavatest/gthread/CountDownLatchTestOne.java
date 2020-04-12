package com.yang.basicjavatest.gthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : CountDownLatch的学习.
 *                      主线程等待子线程执行完成再执行
 *
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class CountDownLatchTestOne {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch latch = new CountDownLatch(3);
        for(int i=0;i<3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                        //当前线程调用此方法，则计数减一
                        latch.countDown();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            service.execute(runnable);
        }


        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            latch.await();
            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

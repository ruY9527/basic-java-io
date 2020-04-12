package com.yang.basicjavatest.gthread;

import java.util.concurrent.CountDownLatch;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : CountDownLatch Learn Test
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class CountDownLatchTest {

    private static final int NUMBER = 200;

    private static CountDownLatch countDownLatch = new CountDownLatch(NUMBER);

    public static void main(String[] args) {
        System.out.println("1");
        for(int i=0;i<NUMBER;i++){
            new Thread(new ThreadOneRun()).start();
            countDownLatch.countDown();
        }

        try {
            //Thread.currentThread().join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("1 Over");
    }


    public static class ThreadOneRun implements Runnable {
        @Override
        public void run() {
            try{
                countDownLatch.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("模拟执行业务的Log");
        }
    }
}

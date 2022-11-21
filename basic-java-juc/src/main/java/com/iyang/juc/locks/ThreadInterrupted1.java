package com.iyang.juc.locks;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class ThreadInterrupted1 {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // 如果没有被中断
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello world!!!");
                }

            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("主线程中断子线程");
        thread.interrupt();

        thread.join();
        System.out.println("主线程执行完毕");

    }

}

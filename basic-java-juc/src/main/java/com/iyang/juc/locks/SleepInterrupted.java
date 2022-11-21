package com.iyang.juc.locks;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class SleepInterrupted {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("子线程开始睡眠");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("子线程睡眠结束");
            }
        });

        thread.start();
        Thread.sleep(2000);

        // 主线程中断子线程
        thread.interrupt();
    }

}

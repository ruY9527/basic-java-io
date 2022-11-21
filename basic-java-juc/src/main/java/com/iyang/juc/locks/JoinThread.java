package com.iyang.juc.locks;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc:
 ***/
public class JoinThread {

    public static void main(String[] args)  {

        Thread mainThread = Thread.currentThread();

        JoinThread1 thread1 = new JoinThread1();
        JoinThread2 thread2 = new JoinThread2();
        thread2.mainThread = mainThread;

        thread1.start();
        thread2.start();

        try {
            // 从结果中看,主线程中 thread1.join 处会抛出异常
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("main thread: " + e);
            e.printStackTrace();
        }

        /*thread1.start();
        thread2.start();
        System.out.println("主线程启动");

        // 会阻塞等待线程执行完毕
        thread1.join();
        thread2.join();
        System.out.println("主线程执行完毕");*/
    }

    static class JoinThread1 extends Thread {

        @Override
        public void run() {

            System.out.println("JoinThread1开始执行");
            while (1==1){}
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinThread1执行完毕");*/

        }
    }

    static class JoinThread2 extends Thread {

        public Thread mainThread ;

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainThread.interrupt();

            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinThread2执行完毕");*/

        }
    }

}

package com.iyang.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/***
 * @author: baoyang
 * @data: 2022/11/21
 * @desc: 创建线程
 ***/

public class ThreadCreate {


    public static void main(String[] args) throws Exception {

        ThreadCreateByTh one = new ThreadCreateByTh();
        one.setName("thread-one");
        one.start();

        Thread two = new Thread(new RunableTask());
        two.setName("thread-two");
        two.start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        Thread three = new Thread(futureTask);
        three.setName("three");
        three.run();

        Thread.sleep(1000);
        System.out.println("主线程名字: " + Thread.currentThread().getName());

        System.out.println("futureTask回调获取的结果: " + futureTask.get());

    }

    // 姿势一
    static class ThreadCreateByTh extends Thread {

        @Override
        public void run() {
            System.out.println("继承 Thread 子线程发车");
        }
    }

    // 姿势二
    static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("实现 runnable 子线程发车");
        }
    }

    // 姿势三
    static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("实现 Callable 子线程发车");
            return "实现 Callable 子线程发车";
        }

    }
}




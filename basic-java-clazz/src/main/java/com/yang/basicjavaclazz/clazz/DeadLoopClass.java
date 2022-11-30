package com.yang.basicjavaclazz.clazz;

/***
 * basic-java-function-interface
 * com.yang.basicjavaclazz.clazz
 * @author: 鲍洋
 * @data: 2022/11/30
 * @desc:
 ***/
public class DeadLoopClass {

    static {
        if (true){
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true){}
        }
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

}

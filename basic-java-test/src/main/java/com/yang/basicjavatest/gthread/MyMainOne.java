package com.yang.basicjavatest.gthread;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-23
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class MyMainOne {

    public static void main(String[] args) {

        for(int i=0;i<3;i++){
            new MyThreadOne().start();
        }

    }

}

class OneSync {
    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}

class MyThreadOne extends  Thread {
    public void run() {
        OneSync sync = new OneSync();
        sync.test();
    }
}

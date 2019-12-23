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
public class MyMainTwo {

    public static void main(String[] args) {

        for(int i=0;i<3;i++){
            new MyThreadTwo().start();
        }

    }

}

class TwoSync {

    private  final byte[] lock = new byte[0];

    public void test() {

        synchronized(lock){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }

    }
}

class MyThreadTwo extends  Thread {
    public void run() {
        TwoSync sync = new TwoSync();
        sync.test();
    }
}

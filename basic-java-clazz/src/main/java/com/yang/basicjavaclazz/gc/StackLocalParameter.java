package com.yang.basicjavaclazz.gc;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/26 10:53
 * @Version 1.0
 * @qq: 1411091515
 */
public class StackLocalParameter {

    public StackLocalParameter(String name){

    }


    /**
     *  虚拟机栈(栈帧中的本地变量表),中引用的对象, 此时为s , 即为GCRoot,当s设置为null的时候,
     *  localParameter 对象也断掉了与GCRoot的引用链,将被回收.
     */
    public void test(){

        StackLocalParameter s = new StackLocalParameter("localParameter");
        s = null;

    }

}

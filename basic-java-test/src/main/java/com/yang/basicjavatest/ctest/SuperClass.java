package com.yang.basicjavatest.ctest;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-17
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class SuperClass {

    public static int value = 123;

    static {
        System.out.println("父类的静态方法快");
    }

    public SuperClass(){

        System.out.println("父类构造方法调用");
    }


}

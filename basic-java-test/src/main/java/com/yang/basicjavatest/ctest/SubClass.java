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
public class SubClass extends SuperClass {

    public static String name = "GavinYang";

    static {
        System.out.println("子类的静态方法快");
    }

    public SubClass(){

        System.out.println("子类调用的方法");
    }

}

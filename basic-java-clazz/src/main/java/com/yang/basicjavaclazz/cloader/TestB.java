package com.yang.basicjavaclazz.cloader;

/**
 * Created by Yang on 2021/1/5 21:22
 */

public class TestB {

    public void hello(){
        System.out.println("TestB : " + this.getClass().getClassLoader());
    }

}

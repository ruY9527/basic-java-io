package com.yang.basicjavaclazz.cloader;

/**
 * Created by Yang on 2021/1/5 21:21
 */

public class TestA {

    public static void main(String[] args) {

        TestA testA = new TestA();
        testA.hello();

    }

    public void hello(){
        System.out.println("TestA : " + this.getClass().getClassLoader());
        TestB testB = new TestB();
        testB.hello();
    }

}

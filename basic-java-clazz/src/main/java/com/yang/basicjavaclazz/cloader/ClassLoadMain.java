package com.yang.basicjavaclazz.cloader;

//import com.yang.basicjavaclazz.domain.Teacher;

/**
 * 类加载的全过程
 */


public class ClassLoadMain {

    public static final String name = "BaoYang";
    public static final int age = 24;

    // Teacher teacher = new Teacher();

    public int add(){

        int a = 1, b =1 ;
        int c = a + b;
        System.out.println("c的结果是: " + c);
        return c;

    }

    public static void main(String[] args) {

        ClassLoadMain classLoadMain = new ClassLoadMain();
        classLoadMain.add();

    }

}

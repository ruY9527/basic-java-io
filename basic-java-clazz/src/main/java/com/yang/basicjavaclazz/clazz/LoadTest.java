package com.yang.basicjavaclazz.clazz;

/***
 * basic-java-function-interface
 * com.yang.basicjavaclazz.clazz
 * @author: 鲍洋
 * @data: 2022/11/30
 * @desc:
 ***/
public class LoadTest {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = ConstClass.class.getClassLoader();
        System.out.println(classLoader);

        // classLoader.loadClass("com.yang.basicjavaclazz.clazz.Test3");
        //Class.forName("com.yang.basicjavaclazz.clazz.Test3");
        Class.forName("com.yang.basicjavaclazz.clazz.Test3", true , classLoader);
    }

}


class Test3 {

    static {
        System.out.println("Test3 run");
    }

}

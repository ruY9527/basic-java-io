package com.yang.basicjavaclazz.cloader;

import java.lang.reflect.Method;

/**
 * Created by Yang on 2021/1/5 21:25
 */

public class MyClassLoaderTest {

    /**
     *  初次加载 :
     *    TestA : com.yang.basicjavaclazz.cloader.MyClassLoaderParentLoader@7440e464
     *    TestB : sun.misc.Launcher$AppClassLoader@18b4aac2
     *  这里可以看到 TestB 还是使用 Launcher 来加载的.
     *  JVM 在触发类加载的时调用是 ClassLoader.loadClass 方法实现 双亲委派.
     *      委托给父加载器加载
     *      如果父类加载器c查询不到,就调用findClass方法进行加载
     *
     *   重写 loadClass 方法,既可看到打印出来的 classLoader 信息
     *    TestA : com.yang.basicjavaclazz.cloader.MyClassLoaderParentLoader@49476842
     *    TestB : com.yang.basicjavaclazz.cloader.MyClassLoaderParentLoader@49476842
     *
     *  类加载机制是为了处理 依赖冲突 而产生的, 它通过自定义类加载器破坏双亲委派模式,利用类加载传导规则实现了不同模块的类隔离.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        MyClassLoaderParentLoader classLoaderParentLoader =
                new MyClassLoaderParentLoader(Thread.currentThread().getContextClassLoader().getParent());
        // Class<?> aClass = classLoaderParentLoader.findClass("com.yang.basicjavaclazz.cloader.TestA");
        Class<?> aClass = classLoaderParentLoader.loadClass("com.yang.basicjavaclazz.cloader.TestA");
        Method mainMethod = aClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null,new Object[]{args});

    }

}

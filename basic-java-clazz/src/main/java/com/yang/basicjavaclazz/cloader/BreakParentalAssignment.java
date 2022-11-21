package com.yang.basicjavaclazz.cloader;


/**
 * 打破双亲委派模式
 */

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class BreakParentalAssignment extends ClassLoader {

    public String classPath;

    public BreakParentalAssignment(){}

    public BreakParentalAssignment(String classPath){
        this.classPath = classPath;
    }

    public byte[] loadByte(String name) throws Exception {

        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int available = fis.available();
        byte [] data = new byte[available];
        fis.read(data);
        fis.close();
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] bytes = loadByte(name);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)) {
            Class<?> loadedClass = findLoadedClass(name);
            if (loadedClass==null) {
                long t1 = System.nanoTime();
                // 这里判断,是否走 parent的类加载器,如果还是走parent的话,就没有破坏双亲委派,否则就是破坏了双亲委派
                if (name.startsWith("com.yang.basicjavaclazz.domain")){
                    loadedClass = findClass(name);
                } else {
                    loadedClass = getParent().loadClass(name);
                }
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(loadedClass);
            }
            return loadedClass;
        }

    }

    /**
     * 运行结果
     * java.lang.SecurityException: Prohibited package name: java.lang
     * 	at java.lang.ClassLoader.preDefineClass(ClassLoader.java:655)
     * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:754)
     * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:635)
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.findClass(BreakParentalAssignment.java:37)
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.loadClass(BreakParentalAssignment.java:52)
     * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.main(BreakParentalAssignment.java:69)
     * Exception in thread "main" java.lang.ClassNotFoundException
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.findClass(BreakParentalAssignment.java:40)
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.loadClass(BreakParentalAssignment.java:52)
     * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
     * 	at com.yang.basicjavaclazz.cloader.BreakParentalAssignment.main(BreakParentalAssignment.java:69)
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)  throws Exception {

        BreakParentalAssignment breakParentalAssignment = new BreakParentalAssignment("D:/test");

        // 使用自己的类加载器去加载
        Class<?> aClass = breakParentalAssignment.loadClass("java.lang.String");

        Object instance = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(instance, null);

        System.out.println(aClass.getClassLoader().getClass().getName());

    }

}

package com.yang.basicjavaclazz.cloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class SelfClassLoader extends ClassLoader {

    public String classPath;

    public SelfClassLoader(){}

    // ‪D:\Teacher.java
    public SelfClassLoader(String classPath){
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
            // defineClass 将一个字节数组转化为 class 对象,这个字节数组是class文件读取后最终的字节数组
            return defineClass(name, bytes, 0 ,bytes.length);
        }catch (Exception e){
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) throws Exception {
        // 初始化自定义类加载器,会先初始化父类ClassLoader,其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        SelfClassLoader selfClassLoader = new SelfClassLoader("D:/test");
         // D盘创建 test/com/yang/basicjavaclazz/domain的目录,将 Teacher的class文件放入
        Class<?> loadClass = selfClassLoader.loadClass("com.yang.basicjavaclazz.domain.Teacher");

        Object obj = loadClass.newInstance();
        Method declaredMethod = loadClass.getDeclaredMethod("say", null);
        declaredMethod.invoke(obj, null);

        System.out.println(loadClass.getClassLoader().getClass().getName());
    }

}

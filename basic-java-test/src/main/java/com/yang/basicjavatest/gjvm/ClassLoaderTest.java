package com.yang.basicjavatest.gjvm;

import java.io.InputStream;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/18 15:35
 * @Version 1.0
 * @qq: 1411091515
 */


public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
               try{
                   String fileName = name.substring(name.lastIndexOf(".") + 1 ) + ".class";
                   InputStream inputStream = getClass().getResourceAsStream(fileName);
                   if(inputStream == null){
                       return super.loadClass(name);
                   }
                   byte [] b = new byte[inputStream.available()];
                   inputStream.read(b);
                   return defineClass(name,b,0,b.length);
               }catch (Exception e){
                   throw new ClassNotFoundException(name);
               }
            }
        };
        Object instance = classLoader.loadClass("com.yang.basicjavatest.gjvm.ClassLoaderTest").newInstance();

        System.out.println(instance.getClass());
        System.out.println(instance instanceof ClassLoaderTest);
    }

}

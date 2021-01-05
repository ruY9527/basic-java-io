package com.yang.basicjavaclazz.cloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2021/1/5 20:46
 */

public class MyClassLoaderParentLoader extends ClassLoader {

    private ClassLoader jdkClassLoader ;

    private Map<String,String> classPathMap = new HashMap<>();

    /**
     * 注意这里放入的是 class 文件信息,并不是java文件.
     */
    public MyClassLoaderParentLoader(ClassLoader jdkClassLoader){
        this.jdkClassLoader = jdkClassLoader;
        classPathMap.put("com.yang.basicjavaclazz.cloader.TestA","D:\\Java_DaiMa\\idea_github_self\\basic-java-io\\basic-java-clazz\\target\\classes\\com\\yang\\basicjavaclazz\\cloader\\TestA.class");
        classPathMap.put("com.yang.basicjavaclazz.cloader.TestB","D:\\Java_DaiMa\\idea_github_self\\basic-java-io\\basic-java-clazz\\target\\classes\\com\\yang\\basicjavaclazz\\cloader\\TestB.class");
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class result = null;
        try {
            // 因为 com.yang.basicjavaclazz.cloader.TestA 在这里加载是会出现 ClassNotFound 的错误.
            result = jdkClassLoader.loadClass(name);
        }catch (Exception e){
            // e.printStackTrace();
        }
        if(result != null){
            return result;
        }
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if(!file.exists()){
            throw new ClassNotFoundException("The Class Not Found , The Class Info is " + classPath);
        }
        byte[] classData = getClassData(file);
        if(classData == null || classData.length == 0){
            throw new ClassNotFoundException("The Class No Have Data , The Class Is " + classPath);
        }
        return defineClass(classData,0,classData.length);
        // return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if(!file.exists()){
            throw new ClassNotFoundException("No have the class " + classPath);
        }
        byte[] classData = getClassData(file);
        if(classData == null || classData.length == 0){
            throw new ClassNotFoundException("No Have Data In ClassInfo , The Class is " + classPath);
        }

        return defineClass(classData,0,classData.length);
        // return super.findClass(name);
    }

    private byte[] getClassData(File file){
        try (InputStream ins = new FileInputStream(file);ByteArrayOutputStream baso = new ByteArrayOutputStream()){
            byte [] buffer = new byte[4096];
            int byteNumRead = 0;
            while ((byteNumRead = ins.read(buffer)) != -1) {
                baso.write(buffer,0,byteNumRead);
            }
            return baso.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        }
        return new byte[]{};
    }

}

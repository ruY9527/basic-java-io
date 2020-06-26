package com.yang.basicjavaclazz.gc;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/26 10:57
 * @Version 1.0
 * @qq: 1411091515
 *
 * 方法区中静态属性引用.
 */
public class MethodAreaStaicProperties {

    /**
     *  方法区中静态属性引用对象
     */
    public static MethodAreaStaicProperties m;

    /**
     *  方法区中常量引用的对象
     *  m 即为方法区中常量引用,也就为GCRoot,s设置为null后,final对象也不会因为没有与GCRoot建立关联而被回收.
     *
     */
    public static final MethodAreaStaicProperties mm = new MethodAreaStaicProperties("final");

    public MethodAreaStaicProperties(String name){}

    /**
     *  方法区中静态属性引用的对象为s, s为GCRoot,s设置为null,经过GC后,
     *  s所指向的properties对象由于无法与GC Root建立连接关系而被回收
     *
     *  而m作为静态属性,也属于GCRoot,parameter对象依然与GCRoot建立连接,所以此时的parameter对象不会被回收.
     *
    */
    public  void test(){

        MethodAreaStaicProperties s = new MethodAreaStaicProperties("properties");
        s.m = new MethodAreaStaicProperties("parameter");
        s = null;

    }

}

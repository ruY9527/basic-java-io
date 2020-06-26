package com.yang.basicjavaclazz.gc;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/26 0:50
 * @Version 1.0
 * @qq: 1411091515
 *
 *  引用计数法 : 通过对象头中分配一个空间来保存该对象被引用的次数计数,如果该对象被其他都对象引用,则它的引用数就加1,
 *               如果删除该对象的引用,那么它的引用计数就减1. 当该对象的引用计数为0时候,那么该对象就会被回收.
 *  引用计数算法是将垃圾回收分摊到整个应用程序的运行当中了,而不是在进行垃圾收集时，要挂起整个应用的运行,
 *  直到对堆中所有对象的处理都结束。因此，采用引用计数的垃圾收集不属于严格意义上的"Stop-The-World"的垃圾收集机制。
 *
 */
public class ReferenceCountingGC {

    public Object instance;

    public ReferenceCountingGC(String name){

    }

    public void testGc(){

        /**
         * 如果二个对象之间相互引用的话,导致它们的计数永远都不会为0,通过引用计数法,也就永远无法通知GC收集器回收它们.
         */
        ReferenceCountingGC a = new ReferenceCountingGC("objA");
        ReferenceCountingGC b = new ReferenceCountingGC("objB");

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

    }

}

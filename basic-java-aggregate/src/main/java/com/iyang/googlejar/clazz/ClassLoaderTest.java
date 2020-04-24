package com.iyang.googlejar.clazz;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/23 23:19
 * @Version 1.0
 * @qq: 1411091515
 *
 *  类加载器 :
 *  加载类的开放性 : 类加载器(ClassLoader) 是Java语言的一项创新,也是Java流行的原因之一.
 *
 *  在类加载的第一阶段“加载”过程中，需要通过一个类的全限定名来获取定义此类的二进制字节流，完成这个动作的代码块就是 类加载器。
 *  这一动作是放在 Java 虚拟机外部去实现的，以便让应用程序自己决定如何获取所需的类
 *
 *  虚拟机规范并没有指明二进制字节流要从一个 Class 文件获取,或者说根本没有指明从哪里获取,怎么获取.这种开放使用Java在很多领域
 *  得到了充分的运用.
 *     从ZIP包中获取,成为 JAR，EAR，WAR 格式的基础
 *     从网络中候去,Applet最为代表
 *     运行时计算机生成, Proxy代理中,就是用了 ProxyGenerator.generateProxyClass 来为特定的接口生成形势为 $Proxy的代理类二进制字节流
 *     有其他文件生成,最典型的JSP应用,有JSP文件生成对应的Class类
 *
 *   类加载器虽然只用于实现类的加载动作，但是对于任意一个类，
 *   都需要由加载它的类加载器和这个类本身共同确立其在 Java 虚拟机中的 唯一性。
 *   通俗的说，JVM 中两个类是否“相等”，首先就必须是同一个类加载器加载的，
 *   否则，即使这两个类来源于同一个 Class 文件，被同一个虚拟机加载，
 *   只要类加载器不同，那么这两个类必定是不相等的。
 *
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.iyang.googlejar.clazz.ClassLoaderTest").newInstance();
        System.out.println(obj1 instanceof ClassLoaderTest);

        Object obj2 = myLoader.loadClass("com.iyang.googlejar.clazz.ClassLoaderTest").newInstance();
        System.out.println(obj2 instanceof com.iyang.googlejar.clazz.ClassLoaderTest);
    }
}

package com.yang.basicjavaclazz.cloader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

public class TestJDKClassLoader {

    public static void main(String[] args) {

        // null
        System.out.println(String.class.getClassLoader());

        // sun.misc.Launcher$ExtClassLoader@81197d
        System.out.println(DESKeyFactory.class.getClassLoader());

        // sun.misc.Launcher$AppClassLoader@b4aac2
        System.out.println(TestJDKClassLoader.class.getClassLoader());

        System.out.println("------ 分割线 -------");
        // sun.misc.Launcher$AppClassLoader@b4aac
        System.out.println(ClassLoader.getSystemClassLoader());
        // sun.misc.Launcher$ExtClassLoader@81197d
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        // null
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println("----- 再次分割线 ----");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        // ext 扩展jar包加载的路径
        System.out.println("ext扩展jar包加载的文件");
        // C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
        System.out.println(System.getProperty("java.ext.dirs"));

        // appClassPath加载的路径
        System.out.println("appCLassLoader加载文件");
        // C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\charsets.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\deploy.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\access-bridge-32.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\cldrdata.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\dnsns.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\jaccess.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\jfxrt.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\localedata.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\nashorn.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\sunec.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\sunjce_provider.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\sunmscapi.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\sunpkcs11.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\ext\zipfs.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\javaws.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\jce.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\jfr.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\jfxswt.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\jsse.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\management-agent.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\plugin.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\resources.jar;C:\Program Files (x86)\Java\jdk1.8.0_241\jre\lib\rt.jar;D:\coding\github_self\basic-java-io\basic-java-clazz\target\classes;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\boot\spring-boot-starter\2.2.2.RELEASE\spring-boot-starter-2.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\boot\spring-boot\2.2.2.RELEASE\spring-boot-2.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-context\5.2.2.RELEASE\spring-context-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-aop\5.2.2.RELEASE\spring-aop-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-beans\5.2.2.RELEASE\spring-beans-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-expression\5.2.2.RELEASE\spring-expression-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\boot\spring-boot-autoconfigure\2.2.2.RELEASE\spring-boot-autoconfigure-2.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\boot\spring-boot-starter-logging\2.2.2.RELEASE\spring-boot-starter-logging-2.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\apache\logging\log4j\log4j-to-slf4j\2.12.1\log4j-to-slf4j-2.12.1.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\apache\logging\log4j\log4j-api\2.12.1\log4j-api-2.12.1.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\slf4j\jul-to-slf4j\1.7.29\jul-to-slf4j-1.7.29.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-core\5.2.2.RELEASE\spring-core-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\springframework\spring-jcl\5.2.2.RELEASE\spring-jcl-5.2.2.RELEASE.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\yaml\snakeyaml\1.25\snakeyaml-1.25.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\slf4j\slf4j-api\1.7.29\slf4j-api-1.7.29.jar;D:\softwave\dev_softwave\apache-maven-3.2.5-bin\maven_resp\org\openjdk\jol\jol-core\0.9\jol-core-0.9.jar;D:\softwave\dev_softwave\idea\IntelliJ IDEA 2020.1\lib\idea_rt.jar
        System.out.println(System.getProperty("java.class.path"));
    }

}

package com.yang;

import com.yang.spring.bean.SimpleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasicJavaIoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BasicJavaIoApplication.class, args);

        SimpleBean simpleBean = applicationContext.getBean("testBean", SimpleBean.class);
        System.out.println(" SpringApplication.run() after get testBean." + simpleBean);
    }

}

package com.yang.spring.initializers;

import com.yang.spring.bean.SimpleBean;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-9
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class SimpleApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        if(applicationContext instanceof AnnotationConfigServletWebServerApplicationContext){

            //AnnotationConfigWebApplicationContext
            System.out.println("Enter it");

            ((AnnotationConfigServletWebServerApplicationContext) applicationContext).getBeanFactory()
                    .registerSingleton("testBean",new SimpleBean("Gavin-Yang","Init Bean Value"));
        }
        //((AnnotationConfigReactiveWebServerApplicationContext) applicationContext).getBeanFactory().registerSingleton("testBean",new SimpleBean("Gavin-Yang","Init Bean Value"));
    }
}

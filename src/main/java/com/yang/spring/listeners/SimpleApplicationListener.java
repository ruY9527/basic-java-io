package com.yang.spring.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

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
public class SimpleApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof ApplicationStartedEvent){
            System.out.println("  --- Gavin ---- Start Event in initializer");
        } else if(event instanceof ApplicationReadyEvent){
            System.out.println("  --- Gavin ---- ready event in initializer");
        }

    }
}

package com.iyang.basic.function.interfaces.self;

import org.springframework.beans.BeansException;

/**
 * @author Yang
 * 当前服务 : basic-java-function-interface
 * @date 2021/1/7 / 14:54
 */

@FunctionalInterface
public interface StringFactory<T> {

    /**
     * return String Object.
     * @return
     * @throws BeansException
     */
    T getObject() throws BeansException;

}

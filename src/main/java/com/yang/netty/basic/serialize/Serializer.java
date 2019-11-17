package com.yang.netty.basic.serialize;

import com.yang.netty.basic.serialize.impl.JSONSerializer;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-17
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     *  序列化算法
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     *  Java 对象转化为二进制
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转化为Java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}

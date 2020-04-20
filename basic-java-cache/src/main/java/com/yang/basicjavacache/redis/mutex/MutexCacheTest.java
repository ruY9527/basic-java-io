package com.yang.basicjavacache.redis.mutex;

import redis.clients.jedis.Jedis;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-20
 *
 *  Author          : Gavin
 *
 *  Purpose         : 使用 互斥锁来实现.
 *                    简单来说,当缓存失效的时候,不是立刻去 load db操作.而是先使用缓存工具的某些带成功操作的返回值操作
 *                    比如Redis的setnx,去set一个mutex key,当操作返回成功时候,再进行load db的操作并回设缓存;否则就重试调用整个get方法.
 *
 *  History         :
 *
 *</PRE>
 ***************************************************************************/

public class MutexCacheTest {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    public String get(Jedis redis,String key){

        String key_mutex = "";
        String value = redis.get(key);
        if(value == null){
            if("1".equalsIgnoreCase(redis.set(key_mutex, "1", SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 30*60))){

                // String dbValue = db.get(key);
                //  模拟从db中load出来的value
                String dbValue = "dbValue";
                redis.set(key,value);
                redis.expire(key,30*60);
                redis.del(key_mutex);
            }
        } else {
            // 网上一般这个地方会sleep(50).
            get(redis,key);
        }
        return value;
    }


}

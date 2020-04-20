package com.yang.basicjavacache.redis.mutex;

import com.alibaba.fastjson.JSONObject;
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
 *  Purpose         :  1 : 从redis角度来看,确实没有设置过期时间,这就保证了,不会出现热点key问题,也就是"物理不过期.
 *                     2 : 从功能上看,如果不过期,那不就成为了静态的吗? 所以我们把过期时间存在key对应的value里面,如果发现要过期了,
 *                         通过一个后台的异步线程进行缓存的构建,也就是“逻辑”过期.
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class NeverExpireCacheTest {


    /**
     * 构建缓存的时候,其余线程(非构建缓存的线程),可能访问的是老数据,但是对于一般的互联网功能来说还是可以忍受的.
     *
     *
     * @param redis
     * @param key
     * @return
     */
    public String get(Jedis redis, String key){
        String value = redis.get(key);
        JSONObject parseObject = JSONObject.parseObject(value);
        Long timeout = parseObject.getLong("timeout");
        if(timeout <= System.currentTimeMillis()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String keyMuxet = "mutex:" + key;
                    if(redis.setnx(keyMuxet,"1") == 1){
                        redis.expire(keyMuxet,3*60);
                        // String dbValue = db.get(key)   ==> 模拟从DB中获取出数据 Value
                        String dbValue = "";
                        redis.set(key,dbValue);
                        redis.del(keyMuxet);
                    }
                }
            }).start();
        }
        return value;
    }


}

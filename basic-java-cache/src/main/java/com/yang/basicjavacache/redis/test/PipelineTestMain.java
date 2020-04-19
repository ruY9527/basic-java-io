package com.yang.basicjavacache.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class PipelineTestMain {

    public static void main(String[] args) {

        Jedis redis = new Jedis("192.168.18.141", 6379);
        redis.auth("123456");
        Map<String, String> data = new HashMap<String, String>();
        redis.select(8);
        redis.flushDB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            data.clear();
            data.put("k_" + i, "v_" + i);
            redis.hmset("key_" + i, data);
        }
        long end = System.currentTimeMillis();
        System.out.println("    共插入:[" + redis.dbSize() + "]条 .. ");
        System.out.println("1,未使用PIPE批量设值耗时" + (end - start) / 1000 + "秒..");

        redis.select(8);
        redis.flushDB();
        Pipeline pipe = redis.pipelined();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            data.clear();
            data.put("k_" + i, "v_" + i);
            pipe.hmset("key_" + i, data); //将值封装到PIPE对象，此时并未执行，还停留在客户端
        }
        pipe.sync();
        end = System.currentTimeMillis();
        System.out.println("    PIPE共插入:[" + redis.dbSize() + "]条 .. ");
        System.out.println("2,使用PIPE批量设值耗时" + (end - start) / 1000 + "秒 ..");
    }
}

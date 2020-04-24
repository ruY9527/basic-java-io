package com.yang.basicjavacache.redis.breakdown;

import redis.clients.jedis.Jedis;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/19 22:22
 * @Version 1.0
 * @qq: 1411091515
 *
 *  缓存击穿
 */
public class CaCheBreakDownRedis {

    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public void get(Jedis jedis,String key){
        String value = jedis.get(key);
        // 代表缓存已经过期
        if(value == null){
            // 设置 3min 的超时,防止del操作失败的时候,下次缓存过期一直不能load db
            if("1".equalsIgnoreCase(jedis.set(key, 1 + "", SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 3*60))){
                // 代表设置成功

            }

        }
    }

}
